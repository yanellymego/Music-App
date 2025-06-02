import java.util.LinkedList;
import java.util.Random;
import java.util.Collections;

public class Albums implements Collection, Comparable<Albums>{
  private String m_title;
  private LinkedList<Songs> m_list;

  public Albums(String name){
    m_title = name;
    m_list = new LinkedList<Songs>();
  }

  public Albums(String name, LinkedList<Songs> ll){
    m_title = name;
    m_list = ll;
  }

  public String getName(){
    return m_title;
  }

  public LinkedList<Songs> getSongs(){
    return m_list;
  }

  public int size(){
    return m_list.size();
  }

  public void shuffle(){
    Random randy = new Random();
    int playNum = randy.nextInt(m_list.size());
    m_list.get(playNum).play();
  }

  public String toString(){
    String s = "";
    s += "\n" + m_title + ": ";
    if (m_list.size() > 0){
      for (int i = 0; i < m_list.size(); i++){
        if (m_list.get(i) == m_list.getLast()){
          s += m_list.get(i).getName();
        } else {
          s += m_list.get(i).getName() + ", ";
        }
      }
    }

    return s;
  }

  public int compareTo(Albums a){
    int ret;
    if (this.m_list.size() > a.m_list.size()){
      ret = 1;
    } else if (this.m_list.size() < a.m_list.size()){
      ret = -1;
    } else {
      ret = 0;
    }
    return ret;
  }
}
