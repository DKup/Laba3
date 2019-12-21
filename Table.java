package laba3;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class Table extends AbstractTableModel {
private Double[] coefficients;
private Double from;
private Double to;
private Double step;
public Table(Double from, Double to, Double step,
Double[] coefficients) {
this.from = from;
this.to = to;
this.step = step;
this.coefficients = coefficients;
}
public Double getFrom() {
return from;
}
public Double getTo() {
return to;
}
public Double getStep() {
return step;
}
public int getColumnCount() {
// В данной модели два столбца
return 2;
}
public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
return new Double(Math.ceil((to-from)/step)).intValue()+1;
}
public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
double x = from + step*row;
if (col==0) {
// Если запрашивается значение 1-го столбца, то это X
return x;
} else {
// Если запрашивается значение 2-го столбца, то это значение
// многочлена
Double result = 0.0;
// Вычисление значения в точке по схеме Горнера
Double a[] = new Double [3];
a[0]=2.0; a[1]=1.0; a[2]=4.0;
result=a[3];//сумма начиная со свободного члена
for(int i = 1; i<3; i++)
result=result*x+a[3-i];//сумму наращиваем с конца к началу}
return result;
}
}
public String getColumnName(int col) {
switch (col) {
case 0:
// Название 1-го столбца
return "Значение X";
default:
// Название 2-го столбца
return "Значение многочлена";
}
}
public Class<?> getColumnClass(int col) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double
return Double.class;
}
}
