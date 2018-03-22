using System;
using System.Windows.Input;

namespace MyCalculator
{
    public class KeyReact: ICommand
    {
        readonly Action<object> _execute;
        readonly Predicate<object> _canExecute;
        public KeyReact(Action<object> execute)
            : this(execute, canExecute=>true)
        {
            if (execute == null)
                throw new ArgumentNullException("execute");

            _execute = execute;
        }
        public KeyReact(Action<object> execute, Predicate<object> canExecute)
        {
            if (execute == null)
                throw new ArgumentNullException("execute");

            _execute = execute;
            _canExecute = canExecute;
        }
        public bool CanExecute(object parameter)
        {
            return _canExecute == null ? true : _canExecute(parameter);
        }
        public event EventHandler CanExecuteChanged
        {
            add { System.Windows.Input.CommandManager.RequerySuggested += value; }
            remove { System.Windows.Input.CommandManager.RequerySuggested -= value; }
        }
        public void Execute(object parameter)
        {
            _execute(parameter);
        }
    }
}
