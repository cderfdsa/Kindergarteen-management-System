package email;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import email.Sender;

public class EmailPane extends GridPane {
	public ComboBox tf=new ComboBox();
	public ComboBox getTf() {
		return tf;
	}
	public void setTf(ComboBox tf) {
		this.tf = tf;
	}
	public EmailPane(){
		this.setVgap(20);
		this.setPadding(new Insets(11.5,12.5,13.5,14.5));
		this.add(new Label("�ռ��˵�ַ��"),0,0);
		
		tf.setEditable(true);
		tf.setPromptText("someone@example.com    ��ͬ��ַ��;���");
		tf.getItems().addAll(
	            "450489712@qq.com",
	            "1044276659@qq.com",
	            "2677281339@qq.com",
	            "1440403686@qq.com" 
	        );
		this.add(tf,1,0);
		this.add(new Label("�ʼ����ģ�"),0,1);
		TextArea ta=new TextArea(); 
		this.add(ta,1,1);
		Button bt=new Button("����");
		bt.getStyleClass().add("button1");
		bt.setPrefSize(200, 80);
		this.add(bt, 1, 2);
		GridPane.setHalignment(bt, HPos.RIGHT);
			
		bt.setOnAction((ActionEvent e)->{
			if("".equals(ta.getText())){
				windows.Window.messageWindow("", "�ʼ����ݲ���Ϊ��");
			}else{
				String []addresses=(tf.getSelectionModel().getSelectedItem().toString().split(";"));
				String text=ta.getText()+"  �����׶�԰";
				//���÷��ͺ������ҷ���״̬(δʵ��)
				for(int i=0;i<addresses.length;i++)
					Sender.sendmail(addresses[i], text);
				windows.Window.messageWindow("", "�ʼ����ͳɹ�");
			}
				
				
		});
	}
	
}
