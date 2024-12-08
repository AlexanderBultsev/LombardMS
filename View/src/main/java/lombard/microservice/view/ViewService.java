package lombard.microservice.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ViewService {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    @Autowired
    public ViewService(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
        this.restClient = restClientBuilder.build();
    }

    private ServiceInstance getProxy() {
        return discoveryClient.getInstances("proxy")
                .stream().findAny().orElseThrow(() -> new RuntimeException("proxy service unavailable"));
    }


    /*
    Обработчики клиентов
    */
    public Client getClientById(Long id) {
        try {
            ResponseEntity<Client> response = restClient.get()
                    .uri(getProxy().getUri() + "/client/" + id + "/")
                    .retrieve().toEntity(Client.class);

            return response.getBody();
        } catch (RestClientException e) {
            throw new RestClientException("Ошибка при получении клиента", e);
        }
    }

    public List<Client> getClientList() {
        try {
            ResponseEntity<List<Client>> response = restClient.get()
                    .uri(getProxy().getUri() + "/client/list/")
                    .retrieve().toEntity(new ParameterizedTypeReference<List<Client>>() {
                    });

            return Optional.ofNullable(response.getBody())
                    .orElse(Collections.emptyList());
        } catch (RestClientException e) {
            throw new RestClientException("Ошибка при получении списка клиентов", e);
        }
    }


    /*
    Обработчики имущества
    */
    public Property getPropertyById(Long id) {
        try {
            ResponseEntity<Property> response = restClient.get()
                    .uri(getProxy().getUri() + "/property/" + id + "/")
                    .retrieve().toEntity(Property.class);

            return response.getBody();
        } catch (RestClientException e) {
            throw new RestClientException("Ошибка при получении имущества", e);
        }
    }

    public List<Property> getPropertyList() {
        try {
            ResponseEntity<List<Property>> response = restClient.get()
                    .uri(getProxy().getUri() + "/property/list/")
                    .retrieve().toEntity(new ParameterizedTypeReference<List<Property>>() {});

            return Optional.ofNullable(response.getBody())
                    .orElse(Collections.emptyList());
        } catch (RestClientException e) {
            throw new RestClientException("Ошибка при получении списка имущества", e);
        }
    }

    /*
    Обработчики займов
    */
    public Loan getLoanById(Long id) {
        try {
            ResponseEntity<Loan> response = restClient.get()
                    .uri(getProxy().getUri() + "/loan/" + id + "/")
                    .retrieve().toEntity(Loan.class);

            return response.getBody();
        } catch (RestClientException e) {
            throw new RestClientException("Ошибка при получении займа", e);
        }
    }

    public List<Loan> getLoanList() {
        try {
            ResponseEntity<List<Loan>> response = restClient.get()
                    .uri(getProxy().getUri() + "/loan/list/")
                    .retrieve().toEntity(new ParameterizedTypeReference<List<Loan>>() {});

            return Optional.ofNullable(response.getBody())
                    .orElse(Collections.emptyList());
        } catch (RestClientException e) {
            throw new RestClientException("Ошибка при получении списка займов", e);
        }
    }
}
