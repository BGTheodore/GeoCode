import React from 'react';
import { ErrorMessage, useField } from 'formik';

export const TextField = ({label, ...props}) => {
    const [ field, meta] = useField(props);
    return (
        <div className="mb-2" >
            <label htmlFor={field.name}>{label}</label>
            {field.name == "description" ?
            <textarea 
            className={`form-control shadow-none ${meta.touched && meta.error && 'is-invalid' }`}
            placeholder="Veillez entrer la description..."
            rows="6"></textarea>:
            <input 
            className={`form-control shadow-none ${meta.touched && meta.error && 'is-invalid' }`}
            {...field} {...props}
            />
            }
             <ErrorMessage component="div" name={field.name} style={{position: "absolute", color:"red", fontSize: ".6rem"} }/>
        </div>
    )
}