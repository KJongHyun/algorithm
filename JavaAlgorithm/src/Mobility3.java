//vector<string> solution(vector<string> card, vector<string> word) {
//        vector<string> answer = {};
//
//        int a = 0;
//        int b = 0;
//        int c = 0;
//
//
//        string tempa = card[0];
//        string tempb = card[1];
//        string tempc = card[2];
//
//
//
//        for(int i = 0; i<word.size() ; i++ )
//        {
//
//        string w = word[i];
//
//        a = 0;
//        b = 0;
//        c = 0;
//        int d =0;
//
//
//        for(int m = 0; m < w.size(); m++)
//        {
//
//        int flag =0;
//
//
//        for(int j = 0; j < 8; j++)
//        {
//
//
//        if(card[0][j] ==w[m] && flag== 0 )
//        {
//        a++;
//
//        flag = 1;
//        card[0][j] ='1';
//
//        }
//        }
//
//
//
//        for(int j = 0; j < 8; j++)
//        {
//        if(card[1][j] ==w[m] && flag ==0)
//        {
//        b++;
//        flag = 1;
//        card[1][j] ='1';
//        }
//        }
//
//
//
//        for(int j = 0; j < 8; j++)
//        {
//        if(card[2][j] ==w[m] && flag ==0)
//        {
//        c++;
//        flag = 1;
//        card[2][j] ='1';
//        }
//        }
//
//        if(flag == 0)
//        {
//        d++;
//        }
//
//
//
//        }
//
//
//
//        if(a > 0 && b >0 && c >0 && d ==0)
//        {
//
//        answer.push_back(word[i]);
//
//
//        }
//
//        card[0] = tempa;
//        card[1] = tempb;
//        card[2]= tempc;
//
//        a =0;
//        b = 0;
//        c = 0;
//
//
//        }
//
//
//        if(answer.size() == 0)
//        {
//        answer.push_back("-1");
//        }
//
//
//        return answer;
//        }