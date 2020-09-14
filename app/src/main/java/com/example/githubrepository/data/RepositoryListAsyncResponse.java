package com.example.githubrepository.data;

import com.example.githubrepository.model.Repository;

import java.util.ArrayList;

public interface RepositoryListAsyncResponse {
    void processFinished(ArrayList<Repository> repositoryArrayList);
}
