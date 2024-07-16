package org.example;

import org.example.dto.PurchaseTicketDTO;
import org.example.dto.VoyageSearchDTO;
import org.example.entities.Ticket;
import org.example.entities.Voyage;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Voyage.class, VoyageSearchDTO.class).addMappings(mapper -> {
            mapper.map(v -> v.getRiverboat().getDeckType(), VoyageSearchDTO::setDeckType);
            mapper.map(v -> v.getRiverboat().getCafeAvailability(), VoyageSearchDTO::setCafeAvailability);
        });

        modelMapper.typeMap(Ticket.class, PurchaseTicketDTO.class).addMappings(mapper -> {
            mapper.map(t -> t.getCustomer().getFirstName(), PurchaseTicketDTO::setFirstName);
            mapper.map(t -> t.getCustomer().getLastName(), PurchaseTicketDTO::setLastName);
            mapper.map(t -> t.getCustomer().getEmail(), PurchaseTicketDTO::setEmail);
            mapper.map(t -> t.getTicketType().getCategory(), PurchaseTicketDTO::setTicketType);
        });

        return modelMapper;
    }
}