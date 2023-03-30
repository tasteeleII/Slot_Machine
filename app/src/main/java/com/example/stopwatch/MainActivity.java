package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //ImageView imageView, imageView2, imageView3;
    //TextView timeView;
    ImageView imageView;
    //TextView timeView2;
    ImageView imageView2;
    //TextView timeView3;
    ImageView imageView3;
    Button button;
    Button button3;
    int time;
    int time2;
    int time3;
    CountEvent event;
    CountEvent2 event2;
    CountEvent3 event3;
    Handler handler;
    Drawable cherry;
    Drawable grape;
    Drawable pear;
    Drawable strawberry;

    //Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imageView = findViewById(R.id.imageView);
        //imageView2 = findViewById(R.id.imageView2);
        //imageView3 = findViewById(R.id.imageView3);
        pear = getDrawable(R.drawable.pear);
        //timeView = findViewById(R.id.timeView);
        grape = getDrawable(R.drawable.grape);
        //timeView2 = findViewById(R.id.timeView2);
        cherry = getDrawable(R.drawable.cherry);
        //timeView3 = findViewById(R.id.timeView3);
        strawberry = getDrawable(R.drawable.strawberry);

        button = findViewById(R.id.button);
        button3 = findViewById(R.id.button3);

        time = 0;
        time2 = 0;
        time3 = 0;
        event3 = new CountEvent3();
        event2 = new CountEvent2();
        event = new CountEvent();
        handler = new Handler();


        //reset button
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.equals(time = 0);
                //  imageView.setImageDrawable(strawberry);
            }


        });

        //  Start Stop Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (button.getText().equals("Start")) {
                    handler.postDelayed(event, 500); // schedules the initial event, ever click increases the event
                    handler.postDelayed(event2, 1000);
                    handler.postDelayed(event3, 1500);
                    button.setText("Stop");
                } else {
                    handler.removeCallbacks(event); // stops the event scheduler
                    handler.removeCallbacks(event2);
                    handler.removeCallbacks(event3);
                    button.setText("Start");

                }
            }

        });
    }


    private class CountEvent implements Runnable {

        @Override
        public void run() {
            if (time < 3) {
                time++;
            } else if (time == 3) {
                time = 0;
                //timeView.setText(time + "");
            }
        }


    public void imageKey() {
        if (time == 0) {
            imageView.setImageDrawable(cherry);
        } else if (time == 1) {
            imageView.setImageDrawable(pear);
        } else if (time == 2) {
            imageView.setImageDrawable(grape);
        } else if (time == 3) {
            imageView.setImageDrawable(strawberry);
        }

        handler.postDelayed(event, 500); // perpetuates the event after the initial click

    }
}



    private class CountEvent2 implements Runnable {

        @Override
        public void run() {
            if (time2 < 3) {
                time2++;
            } else if (time2 == 3) {
                time2 = 0;
                //timeView2.setText(time2 + "");

            }
        }


            public void imageKey2() {
                if (time2 == 0) {
                    imageView2.setImageDrawable(grape);
                } else if (time2 == 1) {
                    imageView2.setImageDrawable(strawberry);
                } else if (time2 == 2) {
                    imageView2.setImageDrawable(cherry);
                } else if (time2 == 3) {
                    imageView2.setImageDrawable(pear);
                }

                handler.postDelayed(event2, 1000);//perpetuates the event after the initial click

            }
        }


    private class CountEvent3 implements Runnable {
        @Override
        public void run() {
            if (time3 < 3) {
                time3++;
            } else if (time3 == 3) {
                time3 = 0;
                //timeView3.setText(time3 + "");
            }
        }

        public void imageKey3() {
            if (time3 == 0) {
                imageView3.setImageDrawable(strawberry);
            } else if (time3 == 1) {
                imageView3.setImageDrawable(cherry);
            } else if (time3 == 2) {
                imageView3.setImageDrawable(pear);
            } else if (time3 == 3) {
                imageView3.setImageDrawable(grape);
            }

            handler.postDelayed(event3, 1500); // perpetuates the event after the initial click


        }
    }

    public void jackpot() {
        if (time == time2 && time2 == time3){
            Toast t = Toast.makeText(getApplicationContext(), "JACKPOT!!!", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}