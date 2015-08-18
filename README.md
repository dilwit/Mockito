# mockito
This sample projects demonstrates how we can use Mockito in TDD

# Pre requisites
- Java 1.7 or later
- Maven
- Eclipse

# Key mockito annotations and methods used during testing

- @Mock 
This marks fields as mock, creates mock object and this object is not a real object. 

- @InjectMocks 
Will inject all mock objects to the object being tested. 

- @Captor
To capture argument passed into a method.

- MockitoAnnotations.initMocks(this) 
Initialize all annotated objects. 

- when()
- verify()
- never()
- doThrow()
- thenThrow()
- thenReturn()
