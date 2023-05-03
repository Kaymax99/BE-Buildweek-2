package com.BEBuildweek2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import com.BEBuildweek2.model.Address;
import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.model.CustomerType;
import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.repository.AddressDaoRepository;
import com.BEBuildweek2.repository.ClientDaoRepository;
import com.BEBuildweek2.repository.FattureRepository;

@SpringBootTest
class BeBuildweek2ApplicationTests {

	//Test per la classe Address
	//Questi test verificano il corretto funzionamento dei costruttori, del builder e del costruttore senza argomenti di Address. 
	//Verificano anche che i metodi getter funzionino correttamente. 
   
	@Test
    public void testAddressConstructorAndGetters() {
        Long id = 1L;
        String via = "via Roma";
        int civico = 1;
        String localita = "Milano";
        Long cap = 20121L;
        String comune = "Milano";
        Cliente client = new Cliente();
        Address address = new Address(id, via, civico, localita, cap, comune, client);

        assertEquals(id, address.getId());
        assertEquals(via, address.getVia());
        assertEquals(civico, address.getCivico());
        assertEquals(localita, address.getLocalita());
        assertEquals(cap, address.getCap());
        assertEquals(comune, address.getComune());
        assertEquals(client, address.getClient());
    }

    @Test
    public void testAddressBuilder() {
        Long id = 1L;
        String via = "via Roma";
        int civico = 1;
        String localita = "Milano";
        Long cap = 20121L;
        String comune = "Milano";
        Cliente client = new Cliente();
        Address address = Address.builder()
                .id(id)
                .via(via)
                .civico(civico)
                .localita(localita)
                .cap(cap)
                .comune(comune)
                .client(client)
                .build();

        assertEquals(id, address.getId());
        assertEquals(via, address.getVia());
        assertEquals(civico, address.getCivico());
        assertEquals(localita, address.getLocalita());
        assertEquals(cap, address.getCap());
        assertEquals(comune, address.getComune());
        assertEquals(client, address.getClient());
    }

    @Test
    public void testAddressNoArgsConstructor() {
        Address address = new Address();

        assertNotNull(address);
    }
    
    //Test per la classe Cliente 
    
    @Test
	public void testCliente() {
		// Creazione di un cliente di prova
		Cliente cliente = Cliente.builder()
				.cognome("Rossi")
				.nome("Mario")
				.ragioneSociale("ABC s.r.l.")
				.partitaIva("0123456789")
				.email("info@abc.it")
				.telefono("0123456789")
				.fatturatoAnnuale(100000.0)
				.tipoCliente(CustomerType.PA)
				.indirizzoSedeLegale(new Address())
				.indirizzoSedeOperativa(new Address())
				.dataInserimento(LocalDate.now())
				.build();
		
		// Verifica della corretta creazione del cliente
		assertNotNull(cliente);
		assertEquals("Rossi", cliente.getCognome());
		assertEquals("Mario", cliente.getNome());
		assertEquals("ABC s.r.l.", cliente.getRagioneSociale());
		assertEquals("0123456789", cliente.getPartitaIva());
		assertEquals("info@abc.it", cliente.getEmail());
		assertEquals("0123456789", cliente.getTelefono());
	
		assertEquals(CustomerType.PA, cliente.getTipoCliente());
		assertNotNull(cliente.getIndirizzoSedeLegale());
		assertNotNull(cliente.getIndirizzoSedeOperativa());
		assertNotNull(cliente.getDataInserimento());
	}

    //Test per classe Fattura. 
    //In questo test viene creato un oggetto Cliente e un oggetto Fattura 
    //e viene verificato che i valori degli attributi della fattura corrispondano a quelli impostati durante la creazione dell'oggetto.
    
    @Test
	public void testNewFattura() {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setRagioneSociale("Acme srl");
		
		Fattura fattura = Fattura.builder()
				.clienti(cliente)
				.anno(2023)
				.data(Date.valueOf(LocalDate.now()))
				.importo(1000.0)
				.numero(1L)
				.build();
		
		assertNotNull(fattura);
		assertEquals(1L, fattura.getNumero());
		assertEquals(2023, fattura.getAnno());
		assertEquals(1000.0, fattura.getImporto(), 0.001);
		assertEquals(cliente.getId(), fattura.getClienti().getId());
		assertEquals(cliente.getRagioneSociale(), fattura.getClienti().getRagioneSociale());
	}
    
    //Test per classe AddressDaoRepository
    @Autowired
    private AddressDaoRepository addressDaoRepository;
    @Test
    @DirtiesContext
    public void testSaveAddress() {
        // create new address object
        Address address = Address.builder()
                .via("Via Roma")
                .civico(1)
                .localita("Milano")
                .cap(20121L)
                .comune("Milano")
                .build();

        // salva l'indirizzo
        Address savedAddress = addressDaoRepository.save(address);

     // Verifica se l'indirizzo è stato salvato con un ID
        assertNotNull(savedAddress.getId());

     // Controlla se l'indirizzo salvato ha gli stessi attributi dell'indirizzo originale
        assertEquals(address.getVia(), savedAddress.getVia());
        assertEquals(address.getCivico(), savedAddress.getCivico());
        assertEquals(address.getLocalita(), savedAddress.getLocalita());
        assertEquals(address.getCap(), savedAddress.getCap());
        assertEquals(address.getComune(), savedAddress.getComune());
    }

    //Test per la classe ClientDaoRepository
    //// Il metodo setUp elimina tutte le entità del cliente esistenti prima di ogni test.

//Il metodo TestSaveAndFind verifica il salvataggio e il recupero di un'entità del cliente utilizzando i metodi Save and FindByID del repository. 
    //TestFindByEmail e TestFindBypec sono test di prova di ricerca dei clienti tramite e -mail
    
    @Autowired
    private ClientDaoRepository clientDao;

    @BeforeEach
    public void setUp() {
        clientDao.deleteAll();
    }

    @Test
    public void testSaveAndFind() {
        Cliente cliente = Cliente.builder()
                .nome("Mario")
                .cognome("Rossi")
                .email("mario.rossi@example.com")
                .pec("mario.rossi@example.com")
                .dataInserimento(LocalDate.now())
                .build();
        cliente = clientDao.save(cliente);
        assertThat(cliente.getId()).isNotNull();

        Cliente found = clientDao.findById(cliente.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getNome()).isEqualTo(cliente.getNome());
    }

    @Test
    public void testFindByEmail() {
        Cliente cliente = Cliente.builder()
                .nome("Luigi")
                .cognome("Bianchi")
                .email("luigi.bianchi@example.com")
                .pec("luigi.bianchi@example.com")
                .dataInserimento(LocalDate.now().minusDays(1))
                .build();
        cliente = clientDao.save(cliente);
        assertThat(cliente.getId()).isNotNull();

        Cliente found = clientDao.findByEmail("luigi.bianchi@example.com");
        assertThat(found).isNotNull();
        assertThat(found.getCognome()).isEqualTo(cliente.getCognome());
    }

    @Test
    public void testFindByPec() {
        Cliente cliente = Cliente.builder()
                .nome("Giovanni")
                .cognome("Verdi")
                .email("giovanni.verdi@example.com")
                .pec("giovanni.verdi@example.com")
                .dataInserimento(LocalDate.now().minusDays(2))
                .build();
        cliente = clientDao.save(cliente);
        assertThat(cliente.getId()).isNotNull();

        Page<Cliente> page = clientDao.findByPec("giovanni.verdi@example.com", PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isEqualTo(1);
        assertThat(page.getContent()).containsExactly(cliente);
    }
    
    //Test dei metodi di FattureRepository
    
    @Autowired
    private FattureRepository fattureRepository;
    
    @Test
    @Rollback(false)
    public void testCreateFattura() {
        Fattura fattura = new Fattura();
        fattura.setAnno(2022);
        fattura.setNumero(1L);
        fattura.setData(Date.valueOf("2022-05-02"));
        fattura.setImporto(1000.0);
        
        Cliente cliente = new Cliente();
        cliente.setCognome("Rossi");
        cliente.setDataInserimento(LocalDate.now());
        cliente.setDataUltimoContatto(LocalDate.now());
        cliente.setEmail("cliente@cliente.it");
        cliente.setEmailContatto("contatto@cliente.it");
        cliente.setFatturatoAnnuale(5000.0);
        cliente.setNome("Mario");
        cliente.setPartitaIva("01234567890");
        cliente.setPec("pec@cliente.it");
        cliente.setRagioneSociale("Cliente Srl");
        cliente.setTelefono("1234567890");
        cliente.setTelefonoContatto("0987654321");
        cliente.setTipoCliente(CustomerType.PA);
        
        fattura.setClienti(cliente);
        
        fattureRepository.save(fattura);
        
        assertThat(fattureRepository.findById(fattura.getId())).isNotNull();
    }
    
    @Test
    public void testFindAllFatture() {
        assertThat(fattureRepository.findAll()).isNotEmpty();
    }
    
    @Test
    public void testFindById() {
        assertThat(fattureRepository.findById(1L)).isNotNull();
    }
    
    @Test
    @Rollback(false)
    public void testUpdateFattura() {
        Fattura fattura = fattureRepository.findById(1L).orElse(null);
        assertThat(fattura).isNotNull();
        fattura.setImporto(2000.0);
        fattureRepository.save(fattura);
        assertThat(fattureRepository.findById(1L).get().getImporto()).isEqualTo(2000.0);
    }
    
    @Test
    @Rollback(false)
    public void testDeleteFattura() {
        Fattura fattura = fattureRepository.findById(1L).orElse(null);
        assertThat(fattura).isNotNull();
        fattureRepository.delete(fattura);
        assertThat(fattureRepository.findById(1L)).isEmpty();
    }

  
    
    
}
