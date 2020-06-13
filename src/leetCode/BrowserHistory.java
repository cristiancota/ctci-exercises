package leetCode;

import java.util.ArrayList;
import java.util.List;

class BrowserHistory {

    private List<String> _history = null;
    private int _currentIndex = 0;

    public BrowserHistory(String homepage) {
        _history = new ArrayList<>();
        _history.add(_currentIndex, homepage);
    }

    public void visit(String url) {
        _currentIndex++;
        _history.subList(_currentIndex, _history.size()).clear();
        _history.add(_currentIndex, url);
    }

    public String back(int steps) {
        _currentIndex -= steps;
        _currentIndex = Math.max(_currentIndex, 0);
        return _history.get(_currentIndex);
    }

    public String forward(int steps) {
        _currentIndex += steps;
        _currentIndex = Math.min(_currentIndex, _history.size() - 1);
        return _history.get(_currentIndex);
    }
}
