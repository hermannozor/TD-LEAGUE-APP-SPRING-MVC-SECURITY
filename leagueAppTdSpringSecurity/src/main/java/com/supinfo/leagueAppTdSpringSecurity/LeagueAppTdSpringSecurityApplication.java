package com.supinfo.leagueAppTdSpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.supinfo.leagueAppTdSpringSecurity.dao.JourneeRepository;
import com.supinfo.leagueAppTdSpringSecurity.dao.SaisonRepository;
import com.supinfo.leagueAppTdSpringSecurity.entities.Journee;
import com.supinfo.leagueAppTdSpringSecurity.entities.Saison;

@SpringBootApplication(exclude= SecurityAutoConfiguration.class)
public class LeagueAppTdSpringSecurityApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(LeagueAppTdSpringSecurityApplication.class, args);
		
		SaisonRepository saisonRepo = ctx.getBean(SaisonRepository.class);
		JourneeRepository journeeRepo = ctx.getBean(JourneeRepository.class);
		
		
		saisonRepo.save(new Saison("Saison 2021-2022", "2021-2022"));	
		saisonRepo.save(new Saison("Saison 2022-2023", "2022-2023"));
		saisonRepo.save(new Saison("Saison 2023-2024", "2023-2024"));
		
		journeeRepo.save(new Journee("10",saisonRepo.findByIdentifiantSaison("2021-2022")));
		journeeRepo.save(new Journee("20",saisonRepo.findByIdentifiantSaison("2021-2022")));
		journeeRepo.save(new Journee("30",saisonRepo.findByIdentifiantSaison("2021-2022")));
		journeeRepo.save(new Journee("40",saisonRepo.findByIdentifiantSaison("2021-2022")));
		
		journeeRepo.save(new Journee("10",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("11",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("12",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("13",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("14",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("15",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("16",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("17",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("18",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("19",saisonRepo.findByIdentifiantSaison("2022-2023")));
		journeeRepo.save(new Journee("20",saisonRepo.findByIdentifiantSaison("2022-2023")));
	}

}
