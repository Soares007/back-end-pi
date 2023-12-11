package fatec.sp.gov.br.sistemaescolarbackend.entities;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_TEACHERS")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    
    @Column(columnDefinition = "TEXT")
    private String classSubjects;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setClassSubjects(List<Integer> classSubjects) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.classSubjects = objectMapper.writeValueAsString(classSubjects);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getClassSubjects() {
        try {
            if (classSubjects == null) {
                return Collections.emptyList();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(classSubjects, new TypeReference<List<Integer>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Teacher other = (Teacher) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
