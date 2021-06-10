package com.example.quizproject.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.quizproject.R;
import com.example.quizproject.models.Player;
import com.example.quizproject.repos.PlayerRepository;

import org.jetbrains.annotations.NotNull;

public class AddPlayerFragment extends Fragment {

    private static final int PICK_IMAGE = 1;
    private static final int CREATE_IMAGE = 2;
    private EditText name;
    private ImageView image;
    private Bitmap imageBitmap;
    private Dialog dialog;
    private Uri uri;
    private int numberOfPlayers;
    private TextView txtName1;
    private TextView txtName2;
    private TextView txtName3;
    private TextView txtName4;
    private ImageView imgAddPlayer1;
    private ImageView imgAddPlayer2;
    private ImageView imgAddPlayer3;
    private ImageView imgAddPlayer4;
    private Button btnStart;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    public Button gallery;
    public Button camera;
    public Button add;
    public Button cancel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);

        imgAddPlayer1.setOnClickListener(view1 -> onButtonAddPlayerClicked(view, 1));
        imgAddPlayer2.setOnClickListener(view1 -> onButtonAddPlayerClicked(view, 2));
        imgAddPlayer3.setOnClickListener(view1 -> onButtonAddPlayerClicked(view, 3));
        imgAddPlayer4.setOnClickListener(view1 -> onButtonAddPlayerClicked(view, 4));
        btnStart.setOnClickListener(view1 -> onButtonStartClicked(view));
        //todo get the game title and set it as a title
    }

    private void onButtonAddPlayerClicked(View view, int index) {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_add_player);
        dialog.setTitle("AddPlayer");
        dialog.show();

        add = view.findViewById(R.id.btnAdd);
        cancel = view.findViewById(R.id.btnCloseDialog);
        name = view.findViewById(R.id.editName);
        image = view.findViewById(R.id.imgThumbnail);
        camera = view.findViewById(R.id.btnAddFromCamera);
        gallery = view.findViewById(R.id.btnAddFromGallery);


        if (add != null && camera != null && gallery != null && cancel != null) {
//            add.setOnClickListener(v -> AddPlayerFragment.this.addPlayer(index));
            camera.setOnClickListener(v -> getCameraImage());
            gallery.setOnClickListener(v -> getGalleryImage());
//            cancel.setOnClickListener(v -> dialog.dismiss());
        }
    }

    private void getCameraImage() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, CREATE_IMAGE);
    }

    private void getGalleryImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_IMAGE && resultCode == Activity.RESULT_OK) {
            assert data != null;
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);

        } else if(requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            assert data != null;
            uri =  data.getData();
            String path = getPathFromURI(uri);
            image.setImageURI(uri);
            imageBitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        }
    }

    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = requireActivity().getContentResolver().query(contentUri, proj, null, null,
                null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    private void addPlayer(int i) {
        switch(i) {
            case 1: imgAddPlayer1.setImageBitmap(imageBitmap);
                break;
            case 2: imgAddPlayer2.setImageBitmap(imageBitmap);
                break;
            case 3: imgAddPlayer3.setImageBitmap(imageBitmap);
                break;
            case 4: imgAddPlayer4.setImageBitmap(imageBitmap);
                break;
        }

        switch(i) {
            case 1: txtName1.setText(name.getText().toString());
                break;
            case 2: txtName2.setText(name.getText().toString());
                break;
            case 3: txtName3.setText(name.getText().toString());
                break;
            case 4:txtName4.setText(name.getText().toString());
                break;
        }
//        CurrentGame.numberOfPlayers = CurrentGame.numberOfPlayers + 1;
        //todo create method to track the number of players and increase them

        dialog.dismiss();
    }

    private void initView(View view) {
        btnStart = view.findViewById(R.id.btnPlayGameFromAP);
        txtName1 = view.findViewById(R.id.txtName1);
        txtName2 = view.findViewById(R.id.txtName2);
        txtName3 = view.findViewById(R.id.txtName3);
        txtName4 = view.findViewById(R.id.txtName4);
        imgAddPlayer1 = view.findViewById(R.id.imgAddPlayer1);
        imgAddPlayer2 = view.findViewById(R.id.imgAddPlayer2);
        imgAddPlayer3 = view.findViewById(R.id.imgAddPlayer3);
        imgAddPlayer4 = view.findViewById(R.id.imgAddPlayer4);

//        player1 = PlayerRepository.getInstance().getPlayers().get(0);
//        player2 = PlayerRepository.getInstance().getPlayers().get(1);
//        player3 = PlayerRepository.getInstance().getPlayers().get(2);
//        player4 = PlayerRepository.getInstance().getPlayers().get(3);


    }


    private void onButtonStartClicked(View view) {

        Player player1 = PlayerRepository.getInstance().getPlayers().get(0);
        Player player2 = PlayerRepository.getInstance().getPlayers().get(1);
        Player player3 = PlayerRepository.getInstance().getPlayers().get(2);
        Player player4 = PlayerRepository.getInstance().getPlayers().get(3);
        player1.setName(txtName1.getText().toString());
        player2.setName(txtName2.getText().toString());
        player3.setName(txtName3.getText().toString());
        player4.setName(txtName4.getText().toString());
        player1.setPlayerScore(0);
        player2.setPlayerScore(1);
        player3.setPlayerScore(2);
        player4.setPlayerScore(3);

        Navigation.findNavController(view).navigate(R.id.action_addPlayerFragment_to_prepareQuestionFragment);
    }

    //todo fix fields in the Dialog get values != null
}
