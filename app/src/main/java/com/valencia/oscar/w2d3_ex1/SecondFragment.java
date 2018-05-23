package com.valencia.oscar.w2d3_ex1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements View.OnClickListener{

    private EditText inputMessage;
    private Button sendBt;
    private TextView resultTV;
    private static final String TAG= SecondFragment.class.getSimpleName()+"_TAG";
    private SecondFragment.receiveMessageListener listener;

    public void receiveMessage(String message) {
        resultTV.setText(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btSend:
                listener.messageFromSecondFragment(getMessage());
                break;
        }
    }

    public interface receiveMessageListener{
        void messageFromSecondFragment(String message);
    }

    private String getMessage() {
        return inputMessage.getText().toString();
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Log.d(TAG,"onInflate");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach");
        try{
            listener = (receiveMessageListener) getActivity();
        }catch(ClassCastException  e){
            Log.d(TAG,"The host activity must implement 'receiveMessageListener' interface from 'SecondFragment' class");
        }
        Log.d(TAG,"onAttach");
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        resultTV = view.findViewById(R.id.tvResultSecond);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        inputMessage = view.findViewById(R.id.etMessage);
        sendBt = view.findViewById(R.id.btSend);
        sendBt.setOnClickListener(this);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDestroy");
    }
}
