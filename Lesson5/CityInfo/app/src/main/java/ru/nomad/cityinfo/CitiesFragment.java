package ru.nomad.cityinfo;

import static ru.nomad.cityinfo.CoatOfArmsFragment.PARCEL;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

// Фрагмент выбора города из списка
public class CitiesFragment extends ListFragment {

    boolean isExistCoatofarms;  // Можно ли расположить рядом фрагмент с гербом
    Parcel currentParcel;

    // При создании фрагмента указываем его макет
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    // activity создана, можно к ней обращаться. Выполняются начальные действия
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Для того, чтобы показать список, надо задействовать адаптер.
        // Такая конструкция работает для списков, например ListActivity.
        // Здесь создаём из ресурсов список городов (из массива)
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Cities,
                android.R.layout.simple_list_item_activated_1);

        setListAdapter(adapter);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        View detailsFrame = getActivity().findViewById(R.id.coat_of_arms);
        // getActivity() - получить контекст activity, где расположен фрагмент
        isExistCoatofarms = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        // Если повторное создание, то восстанавливается текущая позиция
        if (savedInstanceState != null) {
            currentParcel = (Parcel) savedInstanceState.getSerializable("CurrentCity");
        } else {
            currentParcel = new Parcel(0, getResources().getTextArray(R.array.Cities)[0].toString());
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // Если можно нарисовать рядом герб, то рисуем
        if (isExistCoatofarms) {
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            showCoatOfArms(currentParcel);
        }
    }

    // Сохраняет текущую позицию (вызывается перед выходом из фрагмента)
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("CurrentCity", currentParcel);
    }

    // Обработка выбора позиции
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        TextView cityNameView = (TextView) v;
        currentParcel = new Parcel(position,
                cityNameView.getText().toString());
        showCoatOfArms(currentParcel);
    }

    // Показать герю. Если возможно - рядом со списко, нет - во второй activity
    private void showCoatOfArms(Parcel parcel) {
        if (isExistCoatofarms) {
            // Выделяет текущий элемент списка
            getListView().setItemChecked(parcel.getImageIndex(), true);

            // Проверяет, что фрагмент с гербом существует в activity
            CoatOfArmsFragment detail = (CoatOfArmsFragment) getFragmentManager().findFragmentById(R.id.coat_of_arms);
            // Если есть необходимость, то выведем герб
            if (detail == null || detail.getParcel().getImageIndex() != parcel.getImageIndex()) {
                // Создаем новый фрагмент с текущей позицией для вывода герба
                detail = CoatOfArmsFragment.newInstance(parcel);
                // Выполняем транзакцию по замене фрагмента
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.coat_of_arms, detail); // замена фрагмента
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        } else {
// Если нельзя вывести герб рядом, откроем вторую activity
            Intent intent = new Intent();
            intent.setClass(getActivity(), CoatOfArmsActivity.class);
// и передадим туда параметры
            intent.putExtra(PARCEL, parcel);
            startActivity(intent);
        }
    }
}
