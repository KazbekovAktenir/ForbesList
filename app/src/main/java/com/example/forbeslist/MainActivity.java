package com.example.forbeslist;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //устанавливаем макет для активности, который определяет внешний вид и интерфейс приложения.
        setContentView(R.layout.activity_main);

        //получаем ссылку на ListView, который определен в макете activity_main.xml с идентификатором forbesListView.
        //этот ListView будет использоваться для отображения списка богатейших людей.
        ListView forbesListView = findViewById(R.id.forbesListView);

        //массив данных с информацией о миллиардерах
        List<Person> people = new ArrayList<>();
        people.add(new Person("Илон Маск", "flag_united_states", "$219 В"));
        people.add(new Person("Джефф Безос", "flag_united_states", "$171 В"));
        people.add(new Person("Бернар Арно", "flag_france", "$158,8 B"));
        people.add(new Person("Билл Гейтс", "flag_united_states", "$129 B"));
        people.add(new Person("Уоррен Баффет", "flag_united_states", "$118 В"));
        people.add(new Person("Ларри Пейдж", "flag_united_states", "$111 В"));
        people.add(new Person("Сергей Брин", "flag_united_states", "$107 В"));
        people.add(new Person("Ларри Эллисон", "flag_united_states", "$106 В"));
        people.add(new Person("Стив Балмер", "flag_united_states", "$91,4 В"));
        people.add(new Person("Мукеш Амбани", "flag_india", "$90,7 В"));
        people.add(new Person("Гаутам Адани", "flag_india", "$90 В"));
        people.add(new Person("Майкл Блумберг", "flag_united_states", "$82 В"));
        people.add(new Person("Карлос Слим Элу", "flag_mexico", "$81, В"));
        people.add(new Person("Франсуаза Бетанкур-Майерс", "flag_france", "$74,8 B"));
        people.add(new Person("Марк Цукерберг", "flag_united_states", "$67,3 В"));
        people.add(new Person("Джим Уолтон", "flag_united_states", "$66,2 В"));
        people.add(new Person("Чжун Шаньшань", "flag_china", "$$65,7 В"));
        people.add(new Person("Чанпэн Чжао", "flag_canada", "$$65 В"));
        people.add(new Person("Владимир Лисин", "flag_russia", "$18,5 B"));
        people.add(new Person("Халиф бен Заид", "flag_saudi_arabia", "$18 B"));
        people.add(new Person("Криштиану Роналду", "flag_portugal", "$1,58 B"));
        people.add(new Person("Лионель Месси", "flag_argentina", "$1,48 B"));
        people.add(new Person("Флойд Мейвезер", "flag_united_states", "$1,41 B"));
        people.add(new Person("Александр Овечкин", "flag_russia", "$75 M"));

        //создаём адаптер и связываем его с ListView
        ForbesListAdapter adapter = new ForbesListAdapter(this, R.layout.list_item, people);
        forbesListView.setAdapter(adapter);

        //установливаем слушатель нажатия на элемент списка для открытия браузера
        forbesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //когда нажимаем на элемент списка, вызывается код внутри onItemClick
            //открывается браузер и выполняется поиск с именем миллиардера, который был выбран
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((Person) parent.getItemAtPosition(position)).getName();
                String url = "https://www.google.ru/search?q=" + name.replace(" ", "+");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}

