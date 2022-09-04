package com.gmail.ivanvaysman.subject_api.component;

import com.gmail.ivanvaysman.subject_api.model.SubjectDTO;
import com.gmail.ivanvaysman.subject_api.service.SubjectService;
import com.gmail.ivanvaysman.subject_api.utils.ChangeHandler;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class SubjectEditor extends VerticalLayout implements KeyNotifier {

  private final SubjectService service;

  private SubjectDTO subjectDTO;

  private final TextField id = new TextField("id");
  private final TextField name = new TextField("name");
  private final TextField comment = new TextField("comment");
  private final TextField amount = new TextField("amount");
  /* Action buttons */
  private final Button save = new Button("Save");
  private final Button edit = new Button("Edit");
  private final HorizontalLayout buttons = new HorizontalLayout(save, edit);

  private final Binder<SubjectDTO> binder = new Binder<>(SubjectDTO.class);

  @Setter private ChangeHandler changeHandler;

  @Autowired
  public SubjectEditor(SubjectService service) {
    this.service = service;

    add(id, name, comment, amount, buttons);

    binder.bindInstanceFields(this);

    setSpacing(true);

    save.getElement().getThemeList().add("primary");

    addKeyPressListener(Key.ENTER, e -> save());
    save.addClickListener(e -> save());

    setVisible(false);
  }

  void save() {
    if (service.isExist(subjectDTO.getId())) {
      service.update(subjectDTO.toSubject());
      changeHandler.onChange();
    } else {
      service.insert(subjectDTO.toSubject());
      changeHandler.onChange();
    }
  }

  public void editSubject(SubjectDTO newSubject) {
    if (newSubject == null) {
      setVisible(false);
      return;
    }
    if (newSubject.getId() != null) {
      subjectDTO = new SubjectDTO(service.findById(newSubject.getId()));
    } else {
      subjectDTO = newSubject;
    }

    binder.setBean(subjectDTO);

    setVisible(true);

    name.focus();
  }
}
