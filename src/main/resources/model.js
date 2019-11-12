const model = {
  Student: {
    _id: 'String',
    isID: 'Long',
    firstName: 'String',
    middleName: 'String',
    lastName: 'String',
    credits: 'Int',
    // EnrolledCourse
    enrolledCourses: [
      {
        parentCourseId: 'String',
        title: 'String',
        abbreviation: 'String',
        semester: 'Semester',
        //Exam
        exams: [{
          parentId: 'String',
          date: 'Date',
          result: 'Int'
        }],
        //Exam
        finalExam: {
          parentId: 'String',
          result: 'Int'
        },
        labs: [{
          room: 'String',
          instructor: 'Teacher'
        }],
        lectures: [{
          //lectures
        }]
//        'enrolledStudents:[{
//          'name: 'String',
//          'isId: 'long'
//        }],
//         'lecturer:{
//           'isId: 'String',
//           'name: 'String'
//         },
//        'instructors:[
//          {
//            'isId: 'String',
//            'name: 'String'
//          },
//          {
//            'isId: 'String',
//            'name: 'String'
//          }
//        ]
      }
    ]
  }
};
