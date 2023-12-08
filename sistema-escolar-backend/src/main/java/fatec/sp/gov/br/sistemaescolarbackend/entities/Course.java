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
@Table(name = "TBL_COURSES")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String courseYear;
    private String semester;
    private String shift;

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

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setClassSubjects(List<Integer> classSubjects) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.classSubjects = objectMapper.writeValueAsString(classSubjects);
        } catch (JsonProcessingException e) {
            // Tratar a exceção de forma apropriada (por exemplo, registrar ou lançar uma exceção personalizada)
            e.printStackTrace();
        }
    }

    public List<Integer> getClassSubjectsList() {
        try {
            if (classSubjects == null) {
                return Collections.emptyList();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(classSubjects, new TypeReference<List<Integer>>() {});
        } catch (IOException e) {
            // Tratar a exceção de forma apropriada (por exemplo, registrar ou lançar uma exceção personalizada)
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
        Course other = (Course) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
