package com.example.githubrepository.data;



        import android.util.Log;

        import com.android.volley.Request;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.example.githubrepository.controller.AppController;
        import com.example.githubrepository.model.Repository;


        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

public class TopRatedRepositories {

    ArrayList<Repository> repositoryArrayList = new ArrayList<>();

    public List<Repository> getRepositories(final RepositoryListAsyncResponse callBack,int pageNumber) {
        String url="https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&page="+pageNumber;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {

                    JSONArray allRepositories = response.getJSONArray("items");
                    Log.d("JSON", "json object:"+response);
                    Log.d("JSON", "itemsArray:"+allRepositories);
                    Log.d("JSON", "length:"+allRepositories.length());
                    for (int repositoryIndex = 0; repositoryIndex < allRepositories.length(); repositoryIndex++) {

                        JSONObject currentRepository = allRepositories.getJSONObject(repositoryIndex);
                        Repository repository = new Repository();
                        repository.setRepositoryName(currentRepository.getString("name"));
                        repository.setRepositoryDescription(currentRepository.getString("description"));
                        repository.setRepositoryOwner(currentRepository.getJSONObject("owner").getString("login"));
                        repository.setRepositoryStarsNumber(Integer.parseInt(currentRepository.getString("stargazers_count")));

                        repositoryArrayList.add(repository);
                        Log.d("JSON", "object:"+repository);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (callBack != null)
                    callBack.processFinished(repositoryArrayList);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

        return repositoryArrayList;
    }

}

