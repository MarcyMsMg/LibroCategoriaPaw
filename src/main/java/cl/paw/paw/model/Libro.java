package cl.paw.paw.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="libro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_seq") //Genero el id con secuencia
    @SequenceGenerator(name = "libro_seq", sequenceName = "libro_seq", allocationSize = 1) //nombre de la secuencia
    private int id_libro;
    @Column(nullable=false) //No pueden ser nulas
    private String nom_libro;
    @Column(nullable=false)
    private String desc_libro;

    @ManyToMany //Muchos a muchos
    @JoinTable( //Owner de la relación
                name = "libro_categoria",
                joinColumns = @JoinColumn(name = "id_libro"),
                inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> categorias = new ArrayList<>();
    

}
