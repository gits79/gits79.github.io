import java.util.LinkedList;
import java.util.Queue;

public class Ford_Fulkerson {
    static final int MAX = 10;
    static final int INF = Integer.MAX_VALUE/2;
    static int result;
    static int c[][] = new int[MAX][MAX];
    static int f[][] = new int[MAX][MAX];
    static int d[];
    static Queue<Integer> queue;




    static void maxFlow(int soucre,int sink){
        // 큐 방문체크 선언
       queue = new LinkedList<>();
       d = new int[MAX];
        while(true){
            queue.clear();
            // 모든 정점은 방문하지 않은 상태로 초기화
            for(int i=0;i<d.length;i++){
                d[i]=-1;
            }
            // 방문 초기화 및 시작점 큐에 넣기
            d[soucre] = soucre;
            queue.add(soucre);
            // 증가경로 다 찾을때 까지 BFS 적용
            while (!queue.isEmpty() && d[sink]==-1){
                int temp = queue.poll();
                //인접 노드 확인
                for(int next=0;next<MAX;next++){
                    // 용량에서 유량을 빼서 흐를수 있는경우와 방문하지 않은경우
                    if(c[temp][next]-f[temp][next]>0 && d[next]==-1){
                        // 방문했다고 처리하고 경로를 기억하기 위해 인접노드로 가는 값 넣음
                        d[next] = temp;
                        //다음 큐에 넣기
                        queue.add(next);
                    }
                }
            }
            //모든 경로 다 찾은 경우 끝
            if(d[sink]==-1)
                break;

            int flow = INF;

            // 도착지에서 출발점으로 돌아오면서 최소 유량 탐색
            for(int i= sink;i !=soucre; i=d[i]){
                flow = Math.min(flow,c[d[i]][i]-f[d[i]][i]);
            }

            //도착지에서 출발점으로 돌아오면서
            // 최소 유량만큼 추가해나감 음의 경우도 계산산
           for(int i= sink;i !=soucre; i=d[i]){
                f[d[i]][i] += flow;
                f[i][d[i]] -= flow;
            }
            result += flow;

        }



    }


    public static void main(String[] args) {
//        //1에서 가는경우
//        c[1][2] = 12;
//        c[1][4] = 11;
//
//        c[2][1] = -12;
//        c[4][1] = -11;
//
//        //2에서 가는경우
//        c[2][3] = 6;
//        c[2][4] = 3;
//        c[2][5] = 5;
//        c[2][6] = 9;
//
//        c[3][2] = -6;
//        c[4][2] = -3;
//        c[5][2] = -5;
//        c[6][2] = -9;
//
//        //3에서 가는경우
//        c[3][6] = 8;
//
//        c[6][3] = -8;
//        //4에서 가는경우
//        c[4][5] = 9;
//
//        c[5][4] = -9;
//
//        //5에서 가는경우
//        c[5][3] = 3;
//        c[5][6] = 4;
//
//        c[3][5] = -3;
//        c[6][5] = -4;

        //0에서 가는 경우
        c[0][1] = 16;
        c[0][2] = 13;
        //0으로 가는 역방향
        c[1][0] = -16;
        c[2][0] = -13;
        //1에서 가는 경우
        c[1][2] = 10;
        c[1][3] = 12;
        //1으로 가는 역방향
        c[2][1] = 4;
        c[3][1] = -12;
        //2에서 가는 경우
        c[2][4] = 14;
        c[2][1] = 4;
        //2로 가는 역방향
        c[4][2] = -14;
        c[1][2] = 10;
        //3에서 가는 경우
        c[3][2] = 9;
        c[3][5] = 20;
        //3으로 가는 역방향
        c[2][3] = -9;
        c[5][3] = -20;
        //4에서 가는 경우
        c[4][3] = 7;
        c[4][5] = 4;
        //4로 가는 역방향
        c[3][4] = -7;
        c[5][4] = -4;






        maxFlow(0,5);
        System.out.println("최대 유량은 "+result);
    }
}
