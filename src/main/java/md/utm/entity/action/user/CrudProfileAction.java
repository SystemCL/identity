package md.utm.entity.action.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.entity.model.dao.ProfileDAO;
import md.utm.entity.model.entity.Profile;



public class CrudProfileAction implements ModelDriven<Profile> {
	
	Profile profile = new Profile();
	ProfileDAO profileDAO;
    private static Session session;
	
	
	public String loadEditProfile(){
		return Action.SUCCESS;
	}


	public Profile getModel() {
		// TODO Auto-generated method stub
		return profile;
	}
	
	public String saveProfile() throws IOException, SQLException{
		
		
		//profile.picture = fotografia 
		/*String photoFilePath = "C:/Users/Vlad/Desktop/nn.jpg";

	        
	        File file = new File(photoFilePath);
	        FileInputStream inputStream = new FileInputStream(file);
	       // Blob blob = Hibernate.getLobCreator(session).createBlob(inputStream, file.length());
	  
	        Blob blob = Hibernate.createBlob(inputStream, file.length());
	        profile.setFirstName("Incercareee");
	        profile.setPicture(blob);
	       // session.save(profile);
	        blob.free();
	        
	        profileDAO.save(profile);*/
		
		return Action.SUCCESS;
	}
	
    private static byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);
         
        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        inputStream.close();
         
        return fileBytes;
    }
	
	/*private static ServiceRegistry serviceRegistry;
    private static Session session;
     
    public static void main(String[] args) throws IOException {
        initSession();
         
        String photoFilePathToRead = "e:/Test/Photo/Puppy.jpg";
        savePersonWithPhoto(photoFilePathToRead);
         
        int personId = 1;
        String photoFilePathToSave = "e:/Test/Photo/MyPuppy.jpg";
        readPhotoOfPerson(personId, photoFilePathToSave);
         
        endSession();
    }
     
    private static void savePersonWithPhoto(String photoFilePath) throws IOException {
        Person person = new Person("Tom");
        byte[] photoBytes = readBytesFromFile(photoFilePath);
        person.setPhoto(photoBytes);
        session.save(person);
    }
     
    private static void readPhotoOfPerson(int personId, String photoFilePath) throws IOException {
        Person person = (Person) session.get(Person.class, personId);
        byte[] photoBytes = person.getPhoto();
        saveBytesToFile(photoFilePath, photoBytes);
    }
     
    private static byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);
         
        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        inputStream.close();
         
        return fileBytes;
    }
     
    private static void saveBytesToFile(String filePath, byte[] fileBytes) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(fileBytes);
        outputStream.close();
    }
     
     
    private static void initSession() {
        Configuration configuration = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
         
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        session = sessionFactory.openSession();
        session.beginTransaction();
    }
     
    private static void endSession() {
        session.getTransaction().commit();
        session.close();
         
        StandardServiceRegistryBuilder.destroy(serviceRegistry);       
    }
*/
}
