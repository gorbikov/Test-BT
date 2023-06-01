import java.util.Arrays;

public class main {

    /*Псевдокод
    Данный псевдокод используется для описания алгоритмов.

    1. Отступ от левого поля указывает на уровень вложенности.
    2. Циклы while, for, repeat и условные конструкции имеют тот же смысл, что и в pascal-е.
    3. Символ “--” обозначает комментарий
    4. Символ “:=” обозначает присваивание
    5. Переменные локальны в рамках процедуры, если не оговорено иначе
    6. Индекс массива пишется в квадратных скобках, конструкция A[i] означает i элемент в массиве A
    7. Возможно использование объектов, состоящих из нескольких полей, или имеющих несколько атрибутов,
    значения поля записывается как ИмяПоля[ИмяОбъекта].
    К примеру, длина массива A записывается как Length[A]; что означают квадратные скобки
    - выясняется по контексту (переменная, обозначающая массив, или объект является указателем
    на составляющие его данные). После присвоения y:=x для любого поля f будет выполняться равенство f[y]=f[x];
    определение того, что является атрибутом – функция, переменная или что-либо еще, - делается по контексту.
    8. Указатель может иметь специальное значение NIL, не указывающее ни на какой объект.
    9. Параметры передаются по значению: вызванная процедура получает собственную копию параметров,
    изменения параметров внутри процедуры снаружи не видно. При передаче объектов копируется указатель
    на данные, соответствующие этому объекту.

            Задача

    Функция сортирующая массив элементов A:
    Sort(A,p,r)
    1 if p < r
    2    then           q := round_half_down((p+r)/2)
    3                       Sort(A,p,q)
    4                       Sort(A,q+1,r)
    5                       Merge(A,p,q,r)

    Пример массива:
    A = (5,2,4,6,1,3,2,6)

    Примера запуска:
    Sort(A,1,length[A])


    Необходимо:
    Разработать алгоритм функции Merge(A,p,q,r) на любом удобном вам языке, с использованием дополнительной памяти или без нее, как вам будет быстрее или удобнее в реализации.
    Если у вас получится - с радостью ждем вас для прохождения дополнительного тестирования.*/
    public static void main(String[] args) {
        int[] A = {5, 2, 4, 6, 1, 3, 2, 6};
        System.out.println("Initial A: " + Arrays.toString(A));
        int[] B = Sort(A, 1, A.length);
        System.out.println("Sroted A: " + Arrays.toString(B));
    }

    public static int[] Sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
            Sort(A, p, q);
            Sort(A, q + 1, r);
            Merge(A, p, q, r);
            return A;
        }
        return null;
    }

    public static void Merge(int[] A, int p, int q, int r) {
        int[] leftA = Arrays.copyOfRange(A, p - 1, q);
        int[] rightA = Arrays.copyOfRange(A, q, r);
        if (arrayMin(rightA) < arrayMin(leftA)) {
            System.arraycopy(rightA, 0, A, p - 1, rightA.length);
            System.arraycopy(leftA, 0, A, q, leftA.length);
        }
        if (arrayMax(leftA) > arrayMin(rightA)) {
            Sort(A, p + 1, r);
        }
    }

    public static int arrayMax(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public static int arrayMin(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
        }
        return min;
    }
}