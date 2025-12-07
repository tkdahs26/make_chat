# make_chat

다섯번째 앱 만들기 채팅앱

사용기술 android java php mysql json


Java와 Android Stringrequest클래스를 사용하여 개발한 실시간 채팅 애플리케이션으로, 회원 관리(가입/로그인), 채팅방 목록 조회, 채팅방 생성 및 실시간 메시지 송수신 기능을 구현했습니다.

회원 관리
기능: 로그인/회원가입, 아이디/비밀번호 찾기, 아이디 중복 확인 기능 구현.
기술: Volley 라이브러리를 이용해 Android와 PHP/DB 간의 통신을 구현






채팅 구현:
기능: 채팅방 내에서 메시지 송수신 및 화면 표시.
기술: 사용자 ID와 상대방 ID를 구분하여 메시지를 전송하고, 채팅 내용을 주기적으로 서버에서 불러와 스크롤 가능한 리스트에 표시.






















DB서버는 닷홈사이트



<img src="https://github.com/tkdahs26/make_chat/assets/48806275/089d9d35-437f-4dcb-9642-6f32a784fcd2 " width="20%" height="200%"/>  채팅을 하기위한 로그인화면



<img src="https://github.com/tkdahs26/make_chat/assets/48806275/3f62b30b-dcee-4551-b7f8-63bbd183c737 " width="20%" height="200%"/>  회원가입




<img src="https://github.com/tkdahs26/make_chat/assets/48806275/563ac090-3562-46a3-9bbf-ff686cd3d330 " width="20%" height="200%"/> 아이디 중복 검사



<img src="https://github.com/tkdahs26/make_chat/assets/48806275/3a432541-e268-40ca-af34-8212b52748ee " width="20%" height="200%"/> 회원가입성공


<img src="https://github.com/tkdahs26/make_chat/assets/48806275/27218db0-bbbf-4a46-8143-47a77f2ee596 " width="20%" height="200%"/> 회원가입한 정보가 DB에 저장됨 

<img src="https://github.com/tkdahs26/make_chat/assets/48806275/e76cb23f-25eb-42e4-b4d6-270e9df51545 " width="20%" height="200%"/>  로그인 성공


<img src="https://github.com/tkdahs26/make_chat/assets/48806275/f2971034-b242-4da1-b4b3-0988b2227351" width="20%" height="200%"/>  로그인 정보가 틀렸을시 실패창

<img src="https://github.com/tkdahs26/make_chat/assets/48806275/3e4f1207-3f82-4c5d-af23-031dac721597" width="20%" height="200%"/> 로그인 성공했을시 채팅방 목록을 볼수 있음


<img src="https://github.com/tkdahs26/make_chat/assets/48806275/6f8a6866-5e4d-42dc-89d8-eb0832d88a39" width="20%" height="200%"/>채팅을 하고싶으면 채팅방과 채팅방비밀번호를 만들어야함

<img src="https://github.com/tkdahs26/make_chat/assets/48806275/cc899875-764d-4dc1-83f9-2e9b3492a564" width="20%" height="200%"/> 채팅방을 만들때 채팅방이름과 비밀번호 상대방아이디를 적으면 만들어짐



<img src="https://github.com/tkdahs26/make_chat/assets/48806275/8ccc3d17-c43a-4e73-97d9-9ff049058315 " width="20%" height="200%"/> 채팅방을 만들고 채팅방목록창에 오면 목록에 만든 채팅방이름이 적혀있음




<img src="https://github.com/tkdahs26/make_chat/assets/48806275/28141f77-e24d-4b9c-9a2f-279bf17936af " width="20%" height="200%"/>  만든 채팅방이 DB에 저장됨 



<img src="https://github.com/tkdahs26/make_chat/assets/48806275/9c721a5f-8fc0-4e2d-84eb-c766c683661f" width="20%" height="200%"/> 채팅방에 입장하려면 채팅방 비밀번호를 적어야 입장가능


<img src="https://github.com/tkdahs26/make_chat/assets/48806275/66431c69-af93-422b-9872-2e3eb6888642 " width="20%" height="200%"/> 채팅장 비밀번호가 틀리면 뜨는 창



<img src="https://github.com/tkdahs26/make_chat/assets/48806275/9f61a381-f39f-448c-8108-8862c6e3e798 " width="20%" height="200%"/> 채팅장 비밀번호가 맞으면 뜨는 창





<img src="https://github.com/tkdahs26/make_chat/assets/48806275/294f3eb1-ba9c-4760-87e9-24afc51c8b49 " width="20%" height="200%"/>  채팅방 입장하면 나오는 창 위에 나와 상대방이 구분되서 


<img src="https://github.com/tkdahs26/make_chat/assets/48806275/1f1c1280-36be-4894-9570-fa268edc6d38" width="20%" height="200%"/> 반쪽은 내가 쓴 채팅이 보이고 나머지 반쪽은 상대가 쓴 채팅이 보임



<img src="https://github.com/tkdahs26/make_chat/assets/48806275/5c42bdf9-daa2-4446-8bcf-dbf9fb28f9c8" width="20%" height="200%"/> 







<img src="https://github.com/tkdahs26/make_chat/assets/48806275/0978e6dd-47b8-4289-bbc4-a155dce2a5b7" width="20%" height="200%"/>  상대방 아이디를 만들어서 제 3자와 통신이 되는지 확인


<img src="https://github.com/tkdahs26/make_chat/assets/48806275/5399c09a-444a-4e4c-9f5b-e451f707b207 " width="20%" height="200%"/> 전에 만들어둔 채팅방 입장을 위해 비밀번호를 적음


<img src="https://github.com/tkdahs26/make_chat/assets/48806275/08ade817-807a-494e-8cde-f890eb23167a " width="20%" height="200%"/> 내가 쓴 글이 무조건 오른쪽칸에 보이게 됨 새로고침 버튼을 눌러야 DB와 통신되서 채팅이 업데이트됨 



<img src="https://github.com/tkdahs26/make_chat/assets/48806275/b9f42c97-58c8-40d2-955e-a0d723493f89 " width="20%" height="200%"/>  채팅내용 자동으로 DB에 저장됨
