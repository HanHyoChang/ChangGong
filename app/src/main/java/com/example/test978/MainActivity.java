package com.example.test978;


import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.ViewFlipper;

@SuppressWarnings("deprecation")

public class MainActivity extends TabActivity {


    ViewFlipper flipper;
    //자동 Flipping 선택 ToggleButton 참조변수


    ArrayAdapter<CharSequence> adspin1, adspin2, adspin3, adspin4, adspin5, adspin6; //어댑터를 선언했습니다. adspint1(서울,인천..) adspin2(강남구,강서구..)
    String choice_do = "";
    String choice_se = "ggg";
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spin1 = (Spinner) findViewById(R.id.spinner);
        final Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spin3 = (Spinner) findViewById(R.id.spinner3);  ///// 지역별 스피너 1 2 3

        final Spinner spin4 = (Spinner) findViewById(R.id.spinner4);
        final Spinner spin5 = (Spinner) findViewById(R.id.spinner5);
        final Spinner spin6 = (Spinner) findViewById(R.id.spinner6);  /////신고요령 스피너 4 5 6

        ImageButton setting=(ImageButton) findViewById(R.id.setting);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳

        setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        Setting.class);
                startActivity(intent);
            }
        });

        TabHost tabHost = getTabHost();
        ImageView tabwidget01 = new ImageView(this);
        tabwidget01.setImageResource(R.drawable.maps_icon);
        TabSpec tabSpecSong = tabHost.newTabSpec("").setIndicator("지역별",getResources().getDrawable(R.drawable.maps_icon));  //지역별 탭호스트

        adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item); //첫번째 스피너에 지역이름 집어넣겠다 ex)서울, 인천, 광주, 대구
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //일단 있어야하는거
        spin1.setAdapter(adspin1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (adspin1.getItem(i).equals("시/도")) {
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_first, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);

                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("구/군")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spiner_first_do, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
                if (adspin1.getItem(i).equals("서울")) { //첫번째 스피너에서 서울 선택했을때 이후 동작
                    //     choice_do = "서울";//일단 보류 필요없음
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);//스핀2가 나오게 하는것
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//스핀2에 저장되게함?
                    spin2.setAdapter(adspin2);

                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {  // 서울 끝까지 다 덮는 괄호
                            if (adspin2.getItem(i).equals("강남구")) { //두번째 스피너를 선택했을때 동작하게 해줌
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울강남구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {// 이게 1번이라치면 2번과 세트
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        if (adspin3.getItem(i).equals("역삼동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    SecondActivity.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("개포동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    SecondActivity2.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("청담동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Cheongdamdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("삼성동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Samsungdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("대치동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daechidong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신사동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinsadong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("논현동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nonhyundong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("압구정동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Apgujeongdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("세곡동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Segogdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("자곡동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jagogdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("율현동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yulhyundong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("일원동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ilwondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("수서동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sooseodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("도곡동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dogogdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("논현1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nonhyun1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("논현2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nonhyun2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("삼성1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Samsung1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("삼성2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Samsung2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("대치1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daechi1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("대치2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daechi2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("대치4동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daechi4dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("역삼1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yuksam1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("역삼2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yuksam2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("도곡1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dogog1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("도곡2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dogog2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("개포1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gaepo1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("개포2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gaepo2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("개포4동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gaepo4dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("일원본동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ilwonbondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("일원1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ilwon1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("일원2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Cheongdamdong.class);
                                            startActivity(intent);
                                        }


                                    }

                                    public void onNothingSelected(AdapterView<?> adapterView) {//이게 2번이라 치면 1번과 세트

                                    }

                                });
                            } else if (adspin2.getItem(i).equals("강동구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울강동구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {// 이게 1번이라치면 2번과 세트
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("명일동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    MyungDong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("고덕동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Godukdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("상일동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sangildong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("길동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gildong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("둔촌동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dunchondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("암사동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Amsadong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("성내동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sungnaedong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("천호동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Chunhodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("강일동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gangildong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("명일1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Myungil1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("명일2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Myungil2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("고덕1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Goduk1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("고덕2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Goduk2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("암사1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Amsa1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("암사2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Amsa2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("암사3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Amsa3dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("천호1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Chunho1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("천호2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Chunho2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("천호3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Chunho3dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("성내1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sungnae1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("성내2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sungnae2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("성내3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sungnae3dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("둔촌1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dunchon1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("둔촌2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dunchon2dong.class);
                                            startActivity(intent);
                                        }

                                    }

                                    public void onNothingSelected(AdapterView<?> adapterView) {//이게 2번이라 치면 1번과 세트

                                    }

                                });


                            } else if (adspin2.getItem(i).equals("강북구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울강북구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("강서구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울강서구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("관악구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울관악구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("광진구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울광진구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("구로구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울구로구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("금천구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울금천구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("노원구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울노원구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("동대문구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울동대문구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("도봉구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울도봉구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("동작구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울동작구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("마포구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울마포구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("서대문구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울서대문구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("성동구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울성동구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("성북구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울성북구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("서초구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울서초구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("송파구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울송파구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("영등포구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울영등포구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("용산구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울용산구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("양천구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울양천구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("은평구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울은평구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("종로구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울종로구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울중구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중랑구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울중랑구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {//아무거도 선택안해도 뜨게하는거 원래 하얀화면이여야 하는데 들어갈때 바로 서울, 강남, 머시기가 선택되어 있음. 그걸 하게 해주는 코드

                        }
                    });
                } else if (adspin1.getItem(i).equals("인천")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);

                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("계양구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_계양구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("남동구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_남동구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("미주홀구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_미주홀구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("부평구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_부평구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("서구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_인천서구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("연수구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_연수구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_인천중구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("도원동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dowondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("동인천")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dongincheondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("북성동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Bookseongdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("송월동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Songwoldong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신포동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinpodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신흥동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinheungdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("연안동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yunandong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("영종동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yungjongdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("용유동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yongyudong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("운서동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yoonseodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("율목동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yulmokdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("중산동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jungsandong.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }

                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정

                else if (adspin1.getItem(i).equals("대구")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------

                    choice_do = "대구";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_daegu, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("동구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구동구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("신암1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신암2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신암3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam3dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신암4동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam4dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신암5동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam5dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신천1,2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sincheon12dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신천3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sincheon3dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("신천4동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sincheon4dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("효목1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Hyomok1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("효목2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Hyomok2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("도평동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dopyungdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("불로봉무동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Bullobongmudong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("지저동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jijeodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("동촌동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dongchondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("방촌동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Bangchondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("공산동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gongsandong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("공산동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gongsandong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("해안동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Haeandong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("안심1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ansim1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("안심2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ansim2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("안심3,4동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ansim34dong.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구서구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구남구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구북구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구중구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구달서구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                        }                                             //----------------------------- 이까지 복사


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                } else if (adspin1.getItem(i).equals("광주")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    choice_do = "광주";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_gwangju, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("광산구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_광산구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_광주북구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_광주남구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                            choice_se = adspin2.getItem(i).toString();
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정 이거 밑에 복붙


                else if (adspin1.getItem(i).equals("울산")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    choice_do = "울산";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_ulsan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산남구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("동구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산동구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("방어동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Bangeodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("화정동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Hwajeongdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("일산동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ilsandong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("전하동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jeonhadong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("미포동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Mipodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("주전동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Joojeondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("동부동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dongboodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("서부동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Seoboodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("대송동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daesongdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("전하1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jeonha1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("전하2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jeonha2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("남목1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nammok1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("남목2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nammok2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("남목3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nammok3dong.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (adspin2.getItem(i).equals("북구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산북구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("울주군")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산울주군, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산중구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정 이거 밑에 복붙

                else if (adspin1.getItem(i).equals("대전")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    choice_do = "대전";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_daejun, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("대덕구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대덕구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("서구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대전서구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("갈마1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Galma1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("갈마2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Galma2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("가수원동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gasoowondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("가장동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gajangdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("기성동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gisungdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("관저1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gwanjeo1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("관저2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gwanjeo2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("괴정동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gwijeongdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("내동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Naedong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("도마1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doma1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("도마2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doma2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("도안동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doandong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("둔산1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doonsan1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("둔산2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doonsan2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("둔산3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doonsan3dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("만년동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Mannyundong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("변동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Byundong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("복수동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boksoodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("용문동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yongmoondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("월평1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Wolpyung1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("월평2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Wolpyung2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("월평3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Wolpyung3dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("용문동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yongmoondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("정림동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jeonglimdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("크린넷지역")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Crinnetdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("크린넷 외 지역")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Elsecrinnetdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("탄방동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Tanbangdong.class);
                                            startActivity(intent);
                                        }

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (adspin2.getItem(i).equals("유성구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_유성구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대전중구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                            choice_se = adspin2.getItem(i).toString();
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정 이거 밑에 복붙

                else if (adspin1.getItem(i).equals("부산")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    choice_do = "부산";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_busan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("강서구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_부산_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("금정구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_금정구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("구서동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gooseodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("금사동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Geumsadong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("금성동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Geumsungdong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("남산동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Namsandong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("부곡1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boogok1dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("부곡2동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boogok2dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("부곡3동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boogok3dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("부곡4동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boogok4dong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("서동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Seodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("선두구동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sundoogoodong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("장전동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jangjeondong.class);
                                            startActivity(intent);
                                        } else if (adspin3.getItem(i).equals("청룡노포동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Cheongryongnopodong.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (adspin2.getItem(i).equals("기장군")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_기장군_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_남구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("동래구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_동래구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_북구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("부산진구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_부산진구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("사상구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_사상구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("사하구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_사하구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("서구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("영도구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_영도구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("연제구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_연제구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_중구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("해운대구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_해운대구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                            choice_se = adspin2.getItem(i).toString();
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정 이거 밑에 복붙

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tabSpecSong.setContent(R.id.tabSong);
//이사이에 뭘 넣으면됨 뷰플리퍼
        flipper = (ViewFlipper) findViewById(R.id.flipper);

        ImageView img = new ImageView(this);


        Animation showIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);//이미지 왼쪽으로 들어옴

        flipper.setInAnimation(showIn);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);//이미지 오른쪽으로 나감

        ImageButton img04=(ImageButton) findViewById(R.id.img04);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        img04.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        SecondActivity.class);
                startActivity(intent);
            }
        });

        ImageButton img03=(ImageButton) findViewById(R.id.img03);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        img03.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        SecondActivity.class);
                startActivity(intent);
            }
        });

        ImageButton img02=(ImageButton) findViewById(R.id.img02);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        img02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        SecondActivity.class);
                startActivity(intent);
            }
        });

        ImageButton img01=(ImageButton) findViewById(R.id.img01);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        img01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        SecondActivity.class);
                startActivity(intent);
            }
        });


        flipper.setFlipInterval(2000);//플리핑 간격(1000ms)

        flipper.startFlipping();//자동 Flipping 시작


        // /////////뷰플리퍼 끝


        tabHost.addTab(tabSpecSong);//지역별 탭호스트 끝

        TabSpec tabSpecArtist = tabHost.newTabSpec("").setIndicator("요령");

        ImageButton newspaper=(ImageButton) findViewById(R.id.a1);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        newspaper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        PaperRecycle.class);
                startActivity(intent);
            }
        });
                                 //여기까지 이미지 버튼 눌렀을때 실행되게 하는 코드

        ImageButton Can=(ImageButton) findViewById(R.id.b1);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        Can.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        Can.class);
                startActivity(intent);
            }
        });


        ImageButton Glass=(ImageButton) findViewById(R.id.c1);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        Glass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        GlassRecycle.class);
                startActivity(intent);
            }
        });

        ImageButton Plastic=(ImageButton) findViewById(R.id.d1);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        Plastic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        Plastic.class);
                startActivity(intent);
            }
        });

        ImageButton Balpo=(ImageButton) findViewById(R.id.e1);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        Balpo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        BalpoRecycle.class);
                startActivity(intent);
            }
        });


        ImageButton Binil=(ImageButton) findViewById(R.id.f1);            //1.여기부터 이미지버튼 만드는것 시작 /지역별 새로운 인텐트 들어가는곳
        Binil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {              //이 안에 이미지 버튼을 눌렀을때 실행되는 동작 코딩
                Intent intent = new Intent(getApplicationContext(),    //새로운 인텐트를 만들어준것
                        Binil.class);
                startActivity(intent);
            }
        });



        //여기까지 이미지 버튼 눌렀을때 실행되게 하는 코드




        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);   /// 요령 자바 끝


        TabSpec tabSpecAlbum = tabHost.newTabSpec("").setIndicator("신고"); //신고 자바 시작  신고쪽 스피너 바꾸는법 adspin1 = adspin4 로 바꾸고 2 = 5로 3 = 6으로 spin 도 spin1= spin4로 2 = 5로 3 = 6 으로 바꾸기

        adspin4 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item); //첫번째 스피너에 지역이름 집어넣겠다 ex)서울, 인천, 광주, 대구
        adspin4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //일단 있어야하는거
        spin4.setAdapter(adspin1);
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (adspin4.getItem(i).equals("시/도")) {
                    adspin5 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_first, android.R.layout.simple_spinner_dropdown_item);
                    adspin5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin5.setAdapter(adspin4);

                    spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin5.getItem(i).equals("구/군")) {
                                adspin6 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spiner_first_do, android.R.layout.simple_dropdown_item_1line);
                                adspin6.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin6.setAdapter(adspin6);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
                if (adspin4.getItem(i).equals("서울")) { //첫번째 스피너에서 서울 선택했을때 이후 동작
                    //     choice_do = "서울";//일단 보류 필요없음
                    adspin5 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_seoul, android.R.layout.simple_spinner_dropdown_item);//스핀2가 나오게 하는것
                    adspin5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//스핀2에 저장되게함?
                    spin5.setAdapter(adspin5);

                    spin5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {  // 서울 끝까지 다 덮는 괄호
                            if (adspin5.getItem(i).equals("강남구")) { //두번째 스피너를 선택했을때 동작하게 해줌
                                adspin6 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울강남구, android.R.layout.simple_dropdown_item_1line);
                                adspin6.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin6.setAdapter(adspin6);

                                spin6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {// 스피너 선택시 그 url로 가게하는 코드
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin6.getItem(i).equals("역삼동")) {
                                            Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.gangnam.go.kr/board/waste/list.do?mid=FM011109"));
                                            startActivity(intent);
                                        } //이까지가 url로 가게하는 코드
                                        else if(adspin6.getItem(i).equals("개포동")){
                                            Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.gangnam.go.kr/board/waste/list.do?mid=FM011109"));
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("청담동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Cheongdamdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("삼성동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Samsungdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("대치동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daechidong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신사동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinsadong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("논현동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nonhyundong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("압구정동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Apgujeongdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("세곡동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Segogdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("자곡동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jagogdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("율현동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yulhyundong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("일원동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ilwondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("수서동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sooseodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("도곡동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dogogdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("논현1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nonhyun1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("논현2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nonhyun2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("삼성1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Samsung1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("삼성2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Samsung2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("대치1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daechi1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("대치2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daechi2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("대치4동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daechi4dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("역삼1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yuksam1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("역삼2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yuksam2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("도곡1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dogog1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("도곡2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dogog2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("개포1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gaepo1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("개포2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gaepo2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("개포4동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gaepo4dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("일원본동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ilwonbondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("일원1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ilwon1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("일원2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Cheongdamdong.class);
                                            startActivity(intent);
                                        }



                                    }

                                    public void onNothingSelected(AdapterView<?> adapterView) {//이게 2번이라 치면 1번과 세트

                                    }

                                });
                            }

                            else if (adspin2.getItem(i).equals("강동구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울강동구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {// 이게 1번이라치면 2번과 세트
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("명일동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    MyungDong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("고덕동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Godukdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("상일동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sangildong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("길동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gildong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("둔촌동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dunchondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("암사동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Amsadong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("성내동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sungnaedong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("천호동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Chunhodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("강일동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gangildong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("명일1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Myungil1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("명일2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Myungil2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("고덕1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Goduk1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("고덕2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Goduk2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("암사1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Amsa1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("암사2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Amsa2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("암사3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Amsa3dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("천호1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Chunho1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("천호2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Chunho2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("천호3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Chunho3dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("성내1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sungnae1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("성내2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sungnae2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("성내3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sungnae3dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("둔촌1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dunchon1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("둔촌2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dunchon2dong.class);
                                            startActivity(intent);
                                        }

                                    }

                                    public void onNothingSelected(AdapterView<?> adapterView) {//이게 2번이라 치면 1번과 세트

                                    }

                                });




                            } else if (adspin2.getItem(i).equals("강북구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울강북구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("강서구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울강서구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("관악구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울관악구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("광진구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울광진구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("구로구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울구로구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("금천구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울금천구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("노원구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울노원구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("동대문구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울동대문구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("도봉구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울도봉구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("동작구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울동작구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("마포구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울마포구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("서대문구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울서대문구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("성동구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울성동구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("성북구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울성북구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("서초구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울서초구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("송파구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울송파구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("영등포구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울영등포구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("용산구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울용산구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("양천구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울양천구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("은평구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울은평구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("종로구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울종로구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울중구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중랑구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서울중랑구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {//아무거도 선택안해도 뜨게하는거 원래 하얀화면이여야 하는데 들어갈때 바로 서울, 강남, 머시기가 선택되어 있음. 그걸 하게 해주는 코드

                        }
                    });
                } else if (adspin1.getItem(i).equals("인천")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_incheon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);

                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("계양구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_계양구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                            else if (adspin2.getItem(i).equals("남동구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_남동구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                            else if (adspin2.getItem(i).equals("미주홀구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_미주홀구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                            else if (adspin2.getItem(i).equals("부평구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_부평구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                            else if (adspin2.getItem(i).equals("서구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_인천서구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                            else if (adspin2.getItem(i).equals("연수구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_연수구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                            else if (adspin2.getItem(i).equals("중구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_인천중구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("도원동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dowondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("동인천")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dongincheondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("북성동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Bookseongdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("송월동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Songwoldong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신포동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinpodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신흥동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinheungdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("연안동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yunandong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("영종동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yungjongdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("용유동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yongyudong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("운서동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yoonseodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("율목동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yulmokdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("중산동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jungsandong.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }

                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정

                else if (adspin1.getItem(i).equals("대구")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------

                    choice_do = "대구";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_daegu, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("동구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구동구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("신암1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신암2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신암3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam3dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신암4동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam4dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신암5동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sinam5dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신천1,2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sincheon12dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신천3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sincheon3dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("신천4동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sincheon4dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("효목1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Hyomok1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("효목2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Hyomok2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("도평동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dopyungdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("불로봉무동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Bullobongmudong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("지저동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jijeodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("동촌동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dongchondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("방촌동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Bangchondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("공산동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gongsandong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("공산동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gongsandong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("해안동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Haeandong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("안심1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ansim1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("안심2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ansim2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("안심3,4동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ansim34dong.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }


                            else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구서구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구남구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                            else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구북구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구중구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                            else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대구달서구, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                        }                                             //----------------------------- 이까지 복사


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                } else if (adspin1.getItem(i).equals("광주")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    choice_do = "광주";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_gwangju, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("광산구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_광산구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_광주북구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_광주남구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                            choice_se = adspin2.getItem(i).toString();
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정 이거 밑에 복붙


                else if (adspin1.getItem(i).equals("울산")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    choice_do = "울산";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_ulsan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산남구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("동구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산동구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("방어동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Bangeodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("화정동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Hwajeongdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("일산동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Ilsandong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("전하동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jeonhadong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("미포동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Mipodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("주전동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Joojeondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("동부동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Dongboodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("서부동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Seoboodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("대송동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Daesongdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("전하1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jeonha1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("전하2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jeonha2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("남목1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nammok1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("남목2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nammok2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("남목3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Nammok3dong.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            } else if (adspin2.getItem(i).equals("북구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산북구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("울주군")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산울주군, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            } else if (adspin2.getItem(i).equals("중구")) {
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_울산중구, android.R.layout.simple_dropdown_item_1line);
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정 이거 밑에 복붙

                else if (adspin1.getItem(i).equals("대전")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    choice_do = "대전";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_daejun, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("대덕구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대덕구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("서구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대전서구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("갈마1동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Galma1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("갈마2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Galma2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("가수원동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gasoowondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("가장동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gajangdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("기성동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gisungdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("관저1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gwanjeo1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("관저2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gwanjeo2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("괴정동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gwijeongdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("내동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Naedong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("도마1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doma1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("도마2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doma2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("도안동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doandong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("둔산1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doonsan1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("둔산2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doonsan2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("둔산3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Doonsan3dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("만년동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Mannyundong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("변동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Byundong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("복수동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boksoodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("용문동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yongmoondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("월평1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Wolpyung1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("월평2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Wolpyung2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("월평3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Wolpyung3dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("용문동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Yongmoondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("정림동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jeonglimdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("크린넷지역")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Crinnetdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("크린넷 외 지역")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Elsecrinnetdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("탄방동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Tanbangdong.class);
                                            startActivity(intent);
                                        }

                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }


                            else if (adspin2.getItem(i).equals("유성구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_유성구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("중구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_대전중구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                            choice_se = adspin2.getItem(i).toString();
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정 이거 밑에 복붙

                else if (adspin1.getItem(i).equals("부산")) { //인천으로 넘어감 다음거도 else if 광주 이런식으로 노가다 ㄱ ---------------   //복사시작 여기.

                    choice_do = "부산";
                    adspin2 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_busan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            if (adspin2.getItem(i).equals("강서구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_부산_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                            else if (adspin2.getItem(i).equals("금정구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_금정구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);

                                spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                        if (adspin3.getItem(i).equals("구서동")) {
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Gooseodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("금사동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Geumsadong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("금성동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Geumsungdong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("남산동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Namsandong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("부곡1동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boogok1dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("부곡2동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boogok2dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("부곡3동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boogok3dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("부곡4동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Boogok4dong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("서동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Seodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("선두구동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Sundoogoodong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("장전동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Jangjeondong.class);
                                            startActivity(intent);
                                        }
                                        else if(adspin3.getItem(i).equals("청룡노포동")){
                                            Intent intent = new Intent(getApplicationContext(),
                                                    Cheongryongnopodong.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                    }
                                });
                            }


                            else if (adspin2.getItem(i).equals("기장군")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_기장군_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }

                            else if (adspin2.getItem(i).equals("남구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_남구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("동래구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_동래구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("북구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_북구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("부산진구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_부산진구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("사상구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_사상구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("사하구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_사하구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("서구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_서구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("영도구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_영도구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("연제구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_연제구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("중구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_중구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }


                            else if (adspin2.getItem(i).equals("해운대구")) { //두번째 스피너를 선택했을때 동작하게 해줌 바꿀때 "강화군" 을 자기가 바꾸고 싶은 지역명으로 바꾸기 //스트링 1번은 이줄 "" 안에있는것과 일치해야함
                                adspin3 = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinner_do_해운대구_dong, android.R.layout.simple_dropdown_item_1line);//인천_dong 부분 각자 맡은 지역으로 바꾸기
                                adspin3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spin3.setAdapter(adspin3);
                            }
                            choice_se = adspin2.getItem(i).toString();
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });

                }//----------------------------이까지 복사 이거 밑에부분에 붙여놓고 수정 이거 밑에 복붙

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tabSpecSong.setContent(R.id.tabSong);





        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);

        TabSpec game = tabHost.newTabSpec("").setIndicator("게임");

        Button button = (Button) findViewById(R.id.kid_quiz);
        Button button1 = (Button) findViewById(R.id.adult_quiz);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Kid_quiz.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Adult_quiz.class);
                startActivity(intent);
            }
        });

        game.setContent(R.id.game);
        tabHost.addTab(game);

        tabHost.setCurrentTab(0);
    }
}
