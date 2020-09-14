package com.example.githubrepository.adapter;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
        import com.example.githubrepository.R;
        import com.example.githubrepository.model.Repository;
        import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Repository> repositoryList;




    public RecyclerViewAdapter(Context context, List<Repository> repositoryList) {
        this.context = context;
        this.repositoryList = repositoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repository repository = repositoryList.get(position);
        holder.repositoryName.setText(repository.getRepositoryName());
        holder.repositoryDescription.setText(repository.getRepositoryDescription());
        holder.repositoryOwner.setText(repository.getRepositoryOwner());
        holder.repositoryRate.setText(String.valueOf(repository.getRepositoryStarsNumber()));


    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView repositoryName;
        public TextView repositoryDescription;
        public TextView repositoryOwner;
        public TextView repositoryRate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            repositoryName = itemView.findViewById(R.id.recyclerRow_repoName);
            repositoryDescription = itemView.findViewById(R.id.recyclerRow_repoDescription);
            repositoryOwner = itemView.findViewById(R.id.recyclerRow_repoOwner);
            repositoryRate = itemView.findViewById(R.id.recyclerRow_repoRate);

        }

    }




}


