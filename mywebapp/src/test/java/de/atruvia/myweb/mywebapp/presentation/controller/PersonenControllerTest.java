package de.atruvia.myweb.mywebapp.presentation.controller;

import de.atruvia.myweb.mywebapp.domain.PersonService;
import de.atruvia.myweb.mywebapp.domain.model.Person;
import de.atruvia.myweb.mywebapp.presentation.dto.PersonDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Sql({"/create.sql", "/insert.sql"})
@ExtendWith(SpringExtension.class)
public class PersonenControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PersonService serviceMock;

    @Test
    void test_1() throws Exception {

        // Arrange
        final Optional<Person> optionalPerson = Optional.of(Person.builder().id("1").vorname("John").nachname("Doe").build());
        when(serviceMock.findeNachId(anyString())).thenReturn(optionalPerson);

        final PersonDTO personDTO = restTemplate.getForObject("/v1/personen/b2e24e74-8686-43ea-baff-d9396b4202e0", PersonDTO.class);
        assertEquals("John",personDTO.getVorname());
    }

    @Test
    void test_2() throws Exception {

        // Arrange
        final Optional<Person> optionalPerson = Optional.of(Person.builder().id("1").vorname("John").nachname("Doe").build());
        when(serviceMock.findeNachId(anyString())).thenReturn(optionalPerson);

        final String personDTO = restTemplate.getForObject("/v1/personen/b2e24e74-8686-43ea-baff-d9396b4202e0", String.class);
        System.out.println(personDTO);
    }

    @Test
    void test_3() throws Exception {

        // Arrange
        final Optional<Person> optionalPerson = Optional.of(Person.builder().id("1").vorname("John").nachname("Doe").build());
        when(serviceMock.findeNachId(anyString())).thenReturn(optionalPerson);

        final ResponseEntity<PersonDTO> entity = restTemplate.getForEntity("/v1/personen/b2e24e74-8686-43ea-baff-d9396b4202e0", PersonDTO.class);
        final PersonDTO personDTO = entity.getBody();
        assertEquals("John",personDTO.getVorname());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    void test_4() throws Exception {

        // Arrange
        final Optional<Person> optionalPerson = Optional.empty();
        when(serviceMock.findeNachId(anyString())).thenReturn(optionalPerson);

        final ResponseEntity<PersonDTO> entity = restTemplate.getForEntity("/v1/personen/b2e24e74-8686-43ea-baff-d9396b4202e0", PersonDTO.class);
        final PersonDTO personDTO = entity.getBody();

        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
    }

}
