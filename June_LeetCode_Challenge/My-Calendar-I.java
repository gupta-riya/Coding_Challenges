// Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

// Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

// A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

// For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

// Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)


class MyCalendar {

    public class Pair{
        int st;
        int ed;
        
        Pair(int start, int end){
            st = start;
            ed = end;
        }
    }    
    
    
    
    
    public ArrayList<Pair> list = new ArrayList<>();
    
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        
        if(list.size() > 0)
        {
            for(Pair p : list)
            {
                if(start < p.ed)
                {
                    if(end > p.st)
                        return false;
                }
            }
        }
        
        list.add(new Pair(start,end));
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
