package com.intro.storecoffe.coffee;

import jakarta.persistence.Entity;//transforme class en table
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data // Génère automatiquement le code répétitif comme les getters, setters
@RequiredArgsConstructor //Génère un constructeur avec les arguments requis
@Builder //Implémente le pattern Builder, qui permet de construire des objets complexes
@Entity //Spécifie que la classe est une entité et qu'elle est mappée à une table de base de données.
public class Coffee {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Coffee(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}




