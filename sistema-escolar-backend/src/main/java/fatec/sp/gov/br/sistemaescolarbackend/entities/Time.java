package fatec.sp.gov.br.sistemaescolarbackend.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_TIMES")
public class Time implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String classSubjectId;
    private String daysofweek;
    private List<String> startTimes;
    private List<String> endTimes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClassSubjectId() {
        return classSubjectId;
    }
    public void setClassSubjectId(String classSubjectId) {
        this.classSubjectId = classSubjectId;
    }
    public String getDaysofweek() {
        return daysofweek;
    }
    public void setDaysofweek(String daysofweek) {
        this.daysofweek = daysofweek;
    }
    public List<String> getStartTimes() {
        return startTimes;
    }
    public void setStartTimes(List<String> startTimes) {
        this.startTimes = startTimes;
    }
    public List<String> getEndTimes() {
        return endTimes;
    }
    public void setEndTimes(List<String> endTimes) {
        this.endTimes = endTimes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((classSubjectId == null) ? 0 : classSubjectId.hashCode());
        result = prime * result + ((daysofweek == null) ? 0 : daysofweek.hashCode());
        result = prime * result + ((startTimes == null) ? 0 : startTimes.hashCode());
        result = prime * result + ((endTimes == null) ? 0 : endTimes.hashCode());
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
        Time other = (Time) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (classSubjectId == null) {
            if (other.classSubjectId != null)
                return false;
        } else if (!classSubjectId.equals(other.classSubjectId))
            return false;
        if (daysofweek == null) {
            if (other.daysofweek != null)
                return false;
        } else if (!daysofweek.equals(other.daysofweek))
            return false;
        if (startTimes == null) {
            if (other.startTimes != null)
                return false;
        } else if (!startTimes.equals(other.startTimes))
            return false;
        if (endTimes == null) {
            if (other.endTimes != null)
                return false;
        } else if (!endTimes.equals(other.endTimes))
            return false;
        return true;
    }
}