package com.gmail.ivanvaysman.subject_api.view;

import com.gmail.ivanvaysman.subject_api.component.SubjectEditor;
import com.gmail.ivanvaysman.subject_api.model.SubjectDTO;
import com.gmail.ivanvaysman.subject_api.service.SubjectService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Route
public class SubjectView extends VerticalLayout {

  private final SubjectService service;
  private final SubjectEditor editor;

  private final Grid<SubjectDTO> subjectGrid = new Grid<>(SubjectDTO.class);
  private final Button addNewButton = new Button("Add new", VaadinIcon.PLUS.create());
  private final Button toJson = new Button("Show in json");
  private final HorizontalLayout toolBar = new HorizontalLayout(addNewButton, toJson);

  @Autowired
  public SubjectView(SubjectService service, SubjectEditor editor) {
    this.service = service;
    this.editor = editor;

    createView();
  }

  private void createView() {
    // added object in view context
    add(toolBar, subjectGrid, editor);

    // edit mode opener
    subjectGrid.asSingleSelect().addValueChangeListener(e -> editor.editSubject(e.getValue()));

    // button listeners
    addNewButton.addClickListener(e -> editor.editSubject(new SubjectDTO()));
    toJson.addClickListener(e -> getUI().orElseThrow().getPage().open("/api/v1/subject/json"));

    // change handler -> if data changes, we can update table right now
    editor.setChangeHandler(
        () -> {
          editor.setVisible(false);
          subjectGrid.setItems(service.getAll().stream().map(SubjectDTO::new).toList());
        });

    // show our table
    subjectGrid.setItems(service.getAll().stream().map(SubjectDTO::new).toList());
  }
}
