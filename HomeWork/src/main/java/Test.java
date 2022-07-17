public class Test{
    public static void main(String[] args) {
        BookLost[] bookLosts= new BookLost[4];
        CardLost[] cardLosts = new CardLost[4];

        bookLosts[0] = new BookLost("Tom", 10, "math");
        bookLosts[1] = new BookLost("Sam", 81, "Eng");
        bookLosts[2] = new BookLost("Jim", 45, "Phy");
        bookLosts[3] = new BookLost("Jay", 23, "Che");

        cardLosts[0] = new CardLost("Jimmy", 45, 114514);
        cardLosts[1] = new CardLost("Sally", 33, 114515);
        cardLosts[2] = new CardLost("Snake", 1, 114517);
        cardLosts[3] = new CardLost("Zero", 110, 114516);

        Solution solution = new Solution();
        solution.sortLost(bookLosts, 0, 3);
        solution.sortLost(cardLosts, 0, 3);

        for (int i = 0; i < 4; i++) {
            System.out.println("name:" + bookLosts[i].name + " time:" + bookLosts[i].time + " bookName:" + bookLosts[i].bookName);
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("name:" + cardLosts[i].name + " time:" + cardLosts[i].time + " cardNumber:" + cardLosts[i].num);
        }

        BookLost bl = (BookLost) solution.selectByKeyword(bookLosts, "Sam");
        CardLost cl = (CardLost) solution.selectByKeyword(cardLosts, "Jimmy");

        System.out.println("查询结果1 " + "name:" + bl.name + " time:" + bl.time + " bookName:" + bl.bookName);
        System.out.println("查询结果2 " + "name:" + cl.name + " time:" + cl.time + " cardNumber:" + cl.num);
    }
}

class Lost {
    String name;
    int time;
}

class CardLost extends Lost{
    int num;

    public CardLost(String name, int time, int num) {
        this.name = name;
        this.time = time;
        this.num = num;
    }
}

class BookLost extends Lost{
    String bookName;

    public BookLost(String name, int time, String bookName) {
        this.name = name;
        this.time = time;
        this.bookName = bookName;
    }
}

class Solution{

        public void sortLost(Lost[] lostArray, int l, int r){
            if (l >= r) return;
            int x = lostArray[l + r >> 1].time;
            int i = l - 1, j = r + 1;
            while (i < j) {
                do i++; while(lostArray[i].time < x);
                do j--; while(lostArray[j].time > x);
                if (i < j) {
                    Lost tmp;
                    tmp = lostArray[i];
                    lostArray[i] = lostArray[j];
                    lostArray[j] = tmp;
                }
            }
            sortLost(lostArray, l, j);
            sortLost(lostArray, j + 1, r);
        }

        public Lost selectByKeyword(Lost[] lostArray,String keyword) {
            Lost result = null;
            for (int i = 0; i < 4; i++) {
                if (lostArray[i].name == keyword) {
                    result = lostArray[i];
                    break;
                }
            }
            return result;
        }

}