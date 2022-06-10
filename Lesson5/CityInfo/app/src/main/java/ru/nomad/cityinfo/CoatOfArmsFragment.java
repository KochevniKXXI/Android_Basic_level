package ru.nomad.cityinfo;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoatOfArmsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

// Фрагмент для вывода герба
public class CoatOfArmsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String PARCEL = "parcel";

    // TODO: Rename and change types of parameters
    private int mIndex;

    public CoatOfArmsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @param parcel@return A new instance of fragment CoatOfArmsFragment.
     */
    // TODO: Rename and change types and number of parameters
    // Фабричный метод создает фрагмент и передает параметр
    public static CoatOfArmsFragment newInstance(Parcel parcel) {
        CoatOfArmsFragment fragment = new CoatOfArmsFragment(); // Создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }

/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIndex = getArguments().getInt(PARCEL);
        }
    }*/

    // Получить индекс из списка (фактически из параметра)
    public Parcel getParcel() {
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_coat_of_arms, container, false);

        // Определить какой герб надо показать, и показать его
        ImageView coatOfArms = layout.findViewById(R.id.imageView);
        TextView cityNameView = layout.findViewById(R.id.textView);

        // Получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        Parcel parcel = getParcel();

        // Выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(parcel.getImageIndex(), -1));
        cityNameView.setText(parcel.getCityName());
        return layout; // Вместо макета используем сразу картинку
    }
}