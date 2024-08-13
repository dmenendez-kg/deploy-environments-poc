// import React, { useState, ChangeEvent } from 'react';

// const BadComponent: React.FC = () => {
//   const [comment, setComment] = useState<string>('');

//   const handleChange = (event: ChangeEvent<HTMLTextAreaElement>) => {
//     setComment(event.target.value);
//   };

//   return (
//     <div>
//       <h1>Leave a Comment</h1>
//       <textarea
//         rows={4}
//         cols={50}
//         placeholder="Type your comment here..."
//         onChange={handleChange}
//         value={comment}
//       />
//       <div>
//         <h2>Preview:</h2>
//         <div
//           // This introduces a potential XSS vulnerability
//           dangerouslySetInnerHTML={{ __html: comment }}
//         />
//       </div>
//     </div>
//   );
// };

// export default BadComponent;
