package leetCode;

import java.util.HashMap;
import java.util.Map;

class BrowserHistory {

    private Map<Integer, String> _history;
    private int _currentIndex = 0;

    public BrowserHistory(String homepage) {
        _history = new HashMap<>();
        _history.put(_currentIndex, homepage);
    }

    public void visit(String url) {
        _currentIndex++;
        _history.put(_currentIndex, url);
        int i = 1;
        while (_history.get(_currentIndex + i) != null) {
            _history.remove(_currentIndex + i);
            i++;
        }
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
