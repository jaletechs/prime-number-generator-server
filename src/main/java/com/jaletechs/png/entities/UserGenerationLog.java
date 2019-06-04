package com.jaletechs.png.entities;

import com.jaletechs.png.entities.security.User;
import com.jaletechs.png.types.GenerationStategyType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

/**
 * Created by jaletechs on 2019-06-01.
 */
@Entity
@Table(name = "user_generation_log")
public class UserGenerationLog {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "execution_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date executionTime;
    @Basic(optional = false)
    @Column(name = "time_elapsed")
    private Long timeElapsed;
    @Column(name = "strategy")
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private GenerationStategyType strategy;
    @Basic(optional = false)
    @Column(name = "number_of_primes")
    private Integer numberOfPrimes;
    @Basic(optional = false)
    @Column(name = "start_of_range")
    private Integer startOfRange;
    @Basic(optional = false)
    @Column(name = "end_of_range")
    private Integer endOfRange;
    @JoinColumn(name = "email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private User user;

    public UserGenerationLog () {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public GenerationStategyType getStrategy() {
        return strategy;
    }

    public void setStrategy(GenerationStategyType strategy) {
        this.strategy = strategy;
    }

    public Integer getNumberOfPrimes() {
        return numberOfPrimes;
    }

    public void setNumberOfPrimes(Integer numberOfPrimes) {
        this.numberOfPrimes = numberOfPrimes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStartOfRange() {
        return startOfRange;
    }

    public void setStartOfRange(Integer startOfRange) {
        this.startOfRange = startOfRange;
    }

    public Integer getEndOfRange() {
        return endOfRange;
    }

    public void setEndOfRange(Integer endOfRange) {
        this.endOfRange = endOfRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGenerationLog)) return false;
        UserGenerationLog that = (UserGenerationLog) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserGenerationLog{" +
                "id=" + id +
                ", executionTime=" + executionTime +
                ", timeElapsed=" + timeElapsed +
                ", strategy=" + strategy +
                ", numberOfPrimes=" + numberOfPrimes +
                ", startOfRange=" + startOfRange +
                ", endOfRange=" + endOfRange +
                ", user=" + user +
                '}';
    }
}
