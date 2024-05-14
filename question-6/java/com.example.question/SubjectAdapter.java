import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SubjectAdapter extends ArrayAdapter<String> {

    private List<String> subjects;
    private LayoutInflater inflater;

    public SubjectAdapter(Context context, List<String> subjects) {
        super(context, 0, subjects);
        this.subjects = subjects;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.text_view_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String subject = subjects.get(position);
        holder.textView.setText(subject);

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}
