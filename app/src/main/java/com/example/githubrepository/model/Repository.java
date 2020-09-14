package com.example.githubrepository.model;

public class Repository {
    private String repositoryName;
    private String repositoryDescription;
    private String repositoryOwner;
    private int repositoryStarsNumber;


    public Repository() {
    }

    public Repository(String repositoryName, String repositoryDescription, String repositoryOwner, int repositoryStarsNumber) {
        this.repositoryName = repositoryName;
        this.repositoryDescription = repositoryDescription;
        this.repositoryOwner = repositoryOwner;
        this.repositoryStarsNumber = repositoryStarsNumber;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "repositoryName='" + repositoryName + '\'' +
                ", repositoryDescription='" + repositoryDescription + '\'' +
                ", repositoryOwner='" + repositoryOwner + '\'' +
                ", repositoryStarsNumber=" + repositoryStarsNumber +
                '}';
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getRepositoryDescription() {
        return repositoryDescription;
    }

    public void setRepositoryDescription(String repositoryDescription) {
        this.repositoryDescription = repositoryDescription;
    }

    public String getRepositoryOwner() {
        return repositoryOwner;
    }

    public void setRepositoryOwner(String repositoryOwner) {
        this.repositoryOwner = repositoryOwner;
    }

    public int getRepositoryStarsNumber() {
        return repositoryStarsNumber;
    }

    public void setRepositoryStarsNumber(int repositoryStarsNumber) {
        this.repositoryStarsNumber = repositoryStarsNumber;
    }
}
