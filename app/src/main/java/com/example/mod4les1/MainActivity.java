package com.example.mod4les1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText search;
    private Button button;
    private TextView output;

    private Map<Integer, String> mapPoem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.input);
        button = findViewById(R.id.button);
        output = findViewById(R.id.rezult);

        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer searchText = Integer.valueOf(search.getText().toString());
            mapPoem = StringMapPoem(poem);

            String resultSearch = searchMapPoem(searchText, mapPoem);

            if (resultSearch == null){
                output.setText("данной строки поиска в поэме не найдено");
            }else {
                output.setText("В поэме найдено " + resultSearch);
            }
        }
    };

    private String searchMapPoem(int search, Map<Integer, String> map){
        String result = "";
        int count = 0;
        Integer maxLength = 0, minLength = 100;

        for (Integer key: map.keySet()){
            if(map.get(key).length() > maxLength){
                maxLength = map.get(key).length();
            }
            if(map.get(key).length() < minLength){
                minLength = map.get(key).length();
            }
        }

        for (Integer key: map.keySet()){

            if(map.get(key).length() == search){
                count++;
                result = result + "\n\n" + map.get(key);
            }
        }

        if (count == 0){
            return null;
        }else {
            return count + "упоминаний введённой фразы в следующих строках " + result;
        }
    }

    private Map<Integer, String> StringMapPoem(String poem){
        String[] poemArr = poem.split("\n");
        Map<Integer, String> mapString = new HashMap<>();

        for (int i = 0; i < poemArr.length; i++) {
            mapString.put(i, poemArr[i]);

        }
        return mapString;
    }

    private String poem = "У лукоморья дуб зелёный;\nЗлатая цепь на дубе том:\nИ днём и ночью кот учёный\nВсё ходит по цепи кругом;\n" +
            "Идёт направо — песнь заводит,\nНалево — сказку говорит.\nТам чудеса: там леший бродит,\nРусалка на ветвях сидит;\n" +
            "Там на неведомых дорожках\nСледы невиданных зверей;\nИзбушка там на курьих ножках\nСтоит без окон, без дверей;\n" +
            "Там лес и дол видений полны;\nТам о заре прихлынут волны\nНа брег песчаный и пустой,\nИ тридцать витязей прекрасных\n" +
            "Чредой из вод выходят ясных,\nИ с ними дядька их морской;\nТам королевич мимоходом\nПленяет грозного царя;\n" +
            "Там в облаках перед народом\nЧерез леса, через моря\nКолдун несёт богатыря;\nВ темнице там царевна тужит,\n" +
            "А бурый волк ей верно служит;\nТам ступа с Бабою Ягой\nИдёт, бредёт сама собой,\nТам царь Кащей над златом чахнет;\n" +
            "Там русский дух… там Русью пахнет!\nИ там я был, и мёд я пил;\nУ моря видел дуб зелёный;\nПод ним сидел, и кот учёный\n" +
            "Свои мне сказки говорил.";




}