package com.cesde.proyecto_integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class ProyectoIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoIntegradorApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void openSwaggerOnStartup() {
		try {
			String url = "http://localhost:8080/swagger-ui/index.html";
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().browse(new URI(url));
			} else {
				System.out.println("Desktop no soportado. Abre manualmente: " + url);
			}
		} catch (Exception e) {
			System.out.println("No se pudo abrir el navegador automáticamente: " + e.getMessage());
		}
	}

}
