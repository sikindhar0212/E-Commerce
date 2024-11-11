package dev.ecommerce.productservice;

import dev.ecommerce.productservice.inheritanceexamples.singletable.Mentor;
import dev.ecommerce.productservice.inheritanceexamples.singletable.MentorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	private MentorRepository mentorRepository;
	public ProductServiceApplication(MentorRepository mentorRepository){
		this.mentorRepository = mentorRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Mentor mentor = new Mentor();
		mentor.setName("Venkat");
		mentor.setEmail("abc@email.com");
		mentor.setAvgRating("180");
        mentorRepository.save(mentor);
	}
}
