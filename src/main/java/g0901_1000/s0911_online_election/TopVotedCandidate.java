package g0901_1000.s0911_online_election;

// #Medium #Array #Hash_Table #Binary_Search #Design

public class TopVotedCandidate {
    private final int[] times;
    private final int[] winnersAtTimeT;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.winnersAtTimeT = new int[times.length];
        int[] counterArray = new int[persons.length];
        int maxVote = 0;
        int maxVotedPerson = 0;
        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            int voteCount = counterArray[person];
            if (voteCount + 1 >= maxVote) {
                maxVote = voteCount + 1;
                maxVotedPerson = person;
            }
            winnersAtTimeT[i] = maxVotedPerson;
            counterArray[persons[i]] = voteCount + 1;
        }
    }

    public int q(int t) {
        int lo = 0;
        int hi = times.length - 1;
        if (t >= times[hi]) {
            lo = hi;
        } else {
            while (lo < hi - 1) {
                int mid = lo + (hi - lo) / 2;
                if (times[mid] == t) {
                    lo = mid;
                    break;
                } else if (times[mid] > t) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            }
        }
        return winnersAtTimeT[lo];
    }
}
