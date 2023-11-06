package com.example.forbeslist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ForbesListAdapter extends ArrayAdapter<Person> {
    private Context context;
    private int resource;

    public ForbesListAdapter(Context context, int resource, List<Person> people) {
        super(context, resource, people);//вызываем конструктор родительского класса ArrayAdapter
        this.context = context;//cохраняем контекст приложения
        this.resource = resource;//сохраняем идентификатор макета элемента списка
    }
    //настраиваем отображение каждого элемента списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = View.inflate(context, resource, null);
        }

        Person person = getItem(position);//получаем объект Person для текущей позиции
        //находим ImageView с идентификатором 'flag' и устанавливаем изображение флага
        ImageView flagImageView = view.findViewById(R.id.flag);
        int flagResource = context.getResources().getIdentifier(
                person.getCountryFlag(), "drawable", context.getPackageName());
        flagImageView.setImageResource(flagResource);
        //находим TextView с идентификаторами 'name' и 'money' и устанавливаем соответствующие значения
        TextView nameTextView = view.findViewById(R.id.name);
        nameTextView.setText(person.getName());

        TextView wealthTextView = view.findViewById(R.id.money);
        wealthTextView.setText(person.getWealth());

        return view;
    }
}

