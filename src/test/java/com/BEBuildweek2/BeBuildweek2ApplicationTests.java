package com.BEBuildweek2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import com.BEBuildweek2.model.Indirizzo;
import com.BEBuildweek2.model.State;
import com.BEBuildweek2.model.Comune;
import com.BEBuildweek2.model.Address;
import com.BEBuildweek2.model.Cliente;
import com.BEBuildweek2.model.CustomerType;
import com.BEBuildweek2.model.EState;
import com.BEBuildweek2.model.Fattura;
import com.BEBuildweek2.repository.AddressDaoRepository;
import com.BEBuildweek2.repository.ClientDaoRepository;
import com.BEBuildweek2.repository.FatturaDaoRepository;
import com.BEBuildweek2.repository.StateRepository;




@SpringBootTest
class BeBuildweek2ApplicationTests {

	//Test per la classe Address
	//Questi test verificano il corretto funzionamento dei costruttori, del builder e del costruttore senza argomenti di Address. 
	//Verificano anche che i metodi getter funzionino correttamente. 
   
	/*
	 * @Test public void testAddressConstructorAndGetters() { Long id = 1L; String
	 * via = "via Roma"; int civico = 1; String localita = "Milano"; Long cap =
	 * 20121L; String comune = "Milano"; Cliente client = new Cliente(); Address
	 * address = new Address(id, via, civico, localita, cap, comune, client);
	 * 
	 * assertEquals(id, address.getId()); assertEquals(via, address.getVia());
	 * assertEquals(civico, address.getCivico()); assertEquals(localita,
	 * address.getLocalita()); assertEquals(cap, address.getCap());
	 * assertEquals(comune, address.getComune()); assertEquals(client,
	 * address.getClient()); }
	 */

	/*
	 * @Test public void testAddressBuilder() { Long id = 1L; String via =
	 * "via Roma"; int civico = 1; String localita = "Milano"; Long cap = 20121L;
	 * String comune = "Milano"; Cliente client = new Cliente(); Address address =
	 * Address.builder() .id(id) .via(via) .civico(civico) .localita(localita)
	 * .cap(cap) .comune(comune) .client(client) .build();
	 * 
	 * assertEquals(id, address.getId()); assertEquals(via, address.getVia());
	 * assertEquals(civico, address.getCivico()); assertEquals(localita,
	 * address.getLocalita()); assertEquals(cap, address.getCap());
	 * assertEquals(comune, address.getComune()); assertEquals(client,
	 * address.getClient()); }
	 */

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
				.cliente(cliente)
				.anno(2023)
				.data(LocalDate.now())
				.importo(1000.0)
				.numero(1L)
				.build();
		
		assertNotNull(fattura);
		assertEquals(1L, fattura.getNumero());
		assertEquals(2023, fattura.getAnno());
		assertEquals(1000.0, fattura.getImporto(), 0.001);
		assertEquals(cliente.getId(), fattura.getCliente().getId());
		assertEquals(cliente.getRagioneSociale(), fattura.getCliente().getRagioneSociale());
	}
    //Test per classe Indirizzo
    @Test
    void testGetVia() {
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setVia("Via Roma");
        assertEquals("Via Roma", indirizzo.getVia());
    }

    @Test
    void testGetCivico() {
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setCivico(10);
        assertEquals(10, indirizzo.getCivico());
    }

    @Test
    void testGetLocalita() {
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setLocalita("Milano");
        assertEquals("Milano", indirizzo.getLocalita());
    }

    @Test
    void testGetCap() {
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setCap(20100);
        assertEquals(20100, indirizzo.getCap());
    }

    @Test
    void testGetComune() {
        Indirizzo indirizzo = new Indirizzo();
        Comune comune = new Comune();
        comune.setComune("Milano");
//        indirizzo.setComune(comune);
//        assertEquals(comune, indirizzo.getComune());
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
    
    @Test
    public void testOrderByName() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("nome").ascending());
        Page<Cliente> result = clientDao.orderByName(pageable);
        assertEquals(10, result.getSize());
       
    }

    @Test
    public void testOrderByFatturato() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("fatturato_annuale").ascending());
        Page<Cliente> result = clientDao.orderByFatturato(pageable);
        assertEquals(10, result.getSize());
       
    }

    @Test
    public void testOrderByDataIns() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("data_inserimento").ascending());
        Page<Cliente> result = clientDao.orderByDataIns(pageable);
        assertEquals(10, result.getSize());
      
    }

    @Test
    public void testOrderByDataUltimo() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("data_ultimo_contatto").ascending());
        Page<Cliente> result = clientDao.orderByDataUltimo(pageable);
        assertEquals(10, result.getSize());
       
    }

    @Test
    public void testFilterByFatturatoUp() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("fatturato_annuale").ascending());
        Page<Cliente> result = clientDao.filterByFatturatoUp(5000.0, pageable);
        assertEquals(10, result.getSize());
        
    }

    @Test
    public void testFilterByFatturatoDown() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("fatturato_annuale").ascending());
        Page<Cliente> result = clientDao.filterByFatturatoDown(10000.0, pageable);
        assertEquals(10, result.getSize());
       
    }

    @Test
    public void testFilterByDataIns() {
        LocalDate data = LocalDate.of(2022, 1, 1);
        Pageable pageable = PageRequest.of(0, 10, Sort.by("data_inserimento").ascending());
        Page<Cliente> result = clientDao.filterByDataIns(data, pageable);}
    
    //Test dei metodi di FattureRepository
    
    @Autowired
    private FatturaDaoRepository fattureRepository;
    
    @Test
    @Rollback(false)
    public void testCreateFattura() {
        Fattura fattura = new Fattura();
        fattura.setAnno(2022);
        fattura.setNumero(1L);
        fattura.setData(LocalDate.now());
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
        
        fattura.setCliente(cliente);
        
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

    @Test
    public void testAscendingName() {

      PageRequest pageRequest = PageRequest.of(0, 5);


      Page<Fattura> result = fattureRepository.ascendingName(pageRequest);

      assertThat(result.getContent().size()).isEqualTo(5);
      assertThat(result.getContent().get(0).getNumero()).isEqualTo(1);
      assertThat(result.getContent().get(1).getNumero()).isEqualTo(2);
      assertThat(result.getContent().get(2).getNumero()).isEqualTo(3);
      assertThat(result.getContent().get(3).getNumero()).isEqualTo(4);
      assertThat(result.getContent().get(4).getNumero()).isEqualTo(5);
    }

    @Test
    public void testFilterByCliente() {
   
      PageRequest pageRequest = PageRequest.of(0, 5);
      Long clienteId = 1L;

 
      Page<Fattura> result = fattureRepository.filterByCliente(clienteId, pageRequest);

 
      assertThat(result.getContent().size()).isEqualTo(5);
      assertThat(result.getContent().get(0).getCliente().getId()).isEqualTo(clienteId);
      assertThat(result.getContent().get(1).getCliente().getId()).isEqualTo(clienteId);
      assertThat(result.getContent().get(2).getCliente().getId()).isEqualTo(clienteId);
      assertThat(result.getContent().get(3).getCliente().getId()).isEqualTo(clienteId);
      assertThat(result.getContent().get(4).getCliente().getId()).isEqualTo(clienteId);
    }

    @Test
    public void testFilterByStato() {

      PageRequest pageRequest = PageRequest.of(0, 5);
      int stato = 2;

      Page<Fattura> result = fattureRepository.filterByStato(stato, pageRequest);


      assertThat(result.getContent().size()).isEqualTo(1);
     
      assertThat(result.getContent().get(0).getNumero()).isEqualTo(2);
    }

    @Test
    public void testFindAllSort() {

      Sort sort = Sort.by(Sort.Direction.DESC, "numero");

      List<Fattura> result = (List<Fattura>) fattureRepository.findAll(sort);

   
      assertThat(result.size()).isEqualTo(10);
      assertThat(result.get(0).getNumero()).isEqualTo(10);
      assertThat(result.get(1).getNumero()).isEqualTo(9);
      assertThat(result.get(2).getNumero()).isEqualTo(8);
      assertThat(result.get(3).getNumero()).isEqualTo(7);
      assertThat(result.get(4).getNumero()).isEqualTo(6);
      assertThat(result.get(5).getNumero()).isEqualTo(5);
      assertThat(result.get(6).getNumero()).isEqualTo(4);
      assertThat(result.get(7).getNumero()).isEqualTo(3);
      assertThat(result.get(8).getNumero()).isEqualTo(2);
      assertThat(result.get(9).getNumero()).isEqualTo(1);
    }

    //State Repository
    @Autowired
    private StateRepository stateRepository;

    @Test
    public void testFindByNome() {
      
        State state = new State();
        state.setNome(EState.ANNULLATA);
        state = stateRepository.save(state);

 
        Optional<State> foundState = Optional.of(stateRepository.findByNome(EState.ANNULLATA));

     
        assertTrue(foundState.isPresent());
        assertEquals(state.getIdState(), foundState.get().getIdState());
        assertEquals(state.getNome(), foundState.get().getNome());
    }
    
  
    
    
    
}
