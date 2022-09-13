package layout

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<com.example.codepathmail.Email>) : androidx.recyclerview.widget.RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    class ViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val senderTextView: android.widget.TextView
        val titleTextView: android.widget.TextView
        val summaryTextView: android.widget.TextView


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view

        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above

            senderTextView = itemView.findViewById(com.example.codepathmail.R.id.senderTv)
            titleTextView = itemView.findViewById(com.example.codepathmail.R.id.titleTv)
            summaryTextView = itemView.findViewById(com.example.codepathmail.R.id.summaryTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = android.view.LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(com.example.codepathmail.R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = emails.get(position)
        // Set item views based on views and data model
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}