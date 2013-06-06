/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.datascience.utils.transformations.thrift.generated;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerNominalResults implements org.apache.thrift.TBase<WorkerNominalResults, WorkerNominalResults._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WorkerNominalResults");

  private static final org.apache.thrift.protocol.TField CM_FIELD_DESC = new org.apache.thrift.protocol.TField("cm", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField EVAL_CM_FIELD_DESC = new org.apache.thrift.protocol.TField("eval_cm", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WorkerNominalResultsStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WorkerNominalResultsTupleSchemeFactory());
  }

  public ConfusionMatrix cm; // required
  public ConfusionMatrix eval_cm; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CM((short)1, "cm"),
    EVAL_CM((short)2, "eval_cm");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CM
          return CM;
        case 2: // EVAL_CM
          return EVAL_CM;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CM, new org.apache.thrift.meta_data.FieldMetaData("cm", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ConfusionMatrix.class)));
    tmpMap.put(_Fields.EVAL_CM, new org.apache.thrift.meta_data.FieldMetaData("eval_cm", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ConfusionMatrix.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WorkerNominalResults.class, metaDataMap);
  }

  public WorkerNominalResults() {
  }

  public WorkerNominalResults(
    ConfusionMatrix cm,
    ConfusionMatrix eval_cm)
  {
    this();
    this.cm = cm;
    this.eval_cm = eval_cm;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WorkerNominalResults(WorkerNominalResults other) {
    if (other.isSetCm()) {
      this.cm = new ConfusionMatrix(other.cm);
    }
    if (other.isSetEval_cm()) {
      this.eval_cm = new ConfusionMatrix(other.eval_cm);
    }
  }

  public WorkerNominalResults deepCopy() {
    return new WorkerNominalResults(this);
  }

  @Override
  public void clear() {
    this.cm = null;
    this.eval_cm = null;
  }

  public ConfusionMatrix getCm() {
    return this.cm;
  }

  public WorkerNominalResults setCm(ConfusionMatrix cm) {
    this.cm = cm;
    return this;
  }

  public void unsetCm() {
    this.cm = null;
  }

  /** Returns true if field cm is set (has been assigned a value) and false otherwise */
  public boolean isSetCm() {
    return this.cm != null;
  }

  public void setCmIsSet(boolean value) {
    if (!value) {
      this.cm = null;
    }
  }

  public ConfusionMatrix getEval_cm() {
    return this.eval_cm;
  }

  public WorkerNominalResults setEval_cm(ConfusionMatrix eval_cm) {
    this.eval_cm = eval_cm;
    return this;
  }

  public void unsetEval_cm() {
    this.eval_cm = null;
  }

  /** Returns true if field eval_cm is set (has been assigned a value) and false otherwise */
  public boolean isSetEval_cm() {
    return this.eval_cm != null;
  }

  public void setEval_cmIsSet(boolean value) {
    if (!value) {
      this.eval_cm = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CM:
      if (value == null) {
        unsetCm();
      } else {
        setCm((ConfusionMatrix)value);
      }
      break;

    case EVAL_CM:
      if (value == null) {
        unsetEval_cm();
      } else {
        setEval_cm((ConfusionMatrix)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CM:
      return getCm();

    case EVAL_CM:
      return getEval_cm();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CM:
      return isSetCm();
    case EVAL_CM:
      return isSetEval_cm();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WorkerNominalResults)
      return this.equals((WorkerNominalResults)that);
    return false;
  }

  public boolean equals(WorkerNominalResults that) {
    if (that == null)
      return false;

    boolean this_present_cm = true && this.isSetCm();
    boolean that_present_cm = true && that.isSetCm();
    if (this_present_cm || that_present_cm) {
      if (!(this_present_cm && that_present_cm))
        return false;
      if (!this.cm.equals(that.cm))
        return false;
    }

    boolean this_present_eval_cm = true && this.isSetEval_cm();
    boolean that_present_eval_cm = true && that.isSetEval_cm();
    if (this_present_eval_cm || that_present_eval_cm) {
      if (!(this_present_eval_cm && that_present_eval_cm))
        return false;
      if (!this.eval_cm.equals(that.eval_cm))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(WorkerNominalResults other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    WorkerNominalResults typedOther = (WorkerNominalResults)other;

    lastComparison = Boolean.valueOf(isSetCm()).compareTo(typedOther.isSetCm());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCm()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cm, typedOther.cm);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEval_cm()).compareTo(typedOther.isSetEval_cm());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEval_cm()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.eval_cm, typedOther.eval_cm);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("WorkerNominalResults(");
    boolean first = true;

    sb.append("cm:");
    if (this.cm == null) {
      sb.append("null");
    } else {
      sb.append(this.cm);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("eval_cm:");
    if (this.eval_cm == null) {
      sb.append("null");
    } else {
      sb.append(this.eval_cm);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (cm != null) {
      cm.validate();
    }
    if (eval_cm != null) {
      eval_cm.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class WorkerNominalResultsStandardSchemeFactory implements SchemeFactory {
    public WorkerNominalResultsStandardScheme getScheme() {
      return new WorkerNominalResultsStandardScheme();
    }
  }

  private static class WorkerNominalResultsStandardScheme extends StandardScheme<WorkerNominalResults> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WorkerNominalResults struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CM
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.cm = new ConfusionMatrix();
              struct.cm.read(iprot);
              struct.setCmIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EVAL_CM
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.eval_cm = new ConfusionMatrix();
              struct.eval_cm.read(iprot);
              struct.setEval_cmIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, WorkerNominalResults struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.cm != null) {
        oprot.writeFieldBegin(CM_FIELD_DESC);
        struct.cm.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.eval_cm != null) {
        oprot.writeFieldBegin(EVAL_CM_FIELD_DESC);
        struct.eval_cm.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WorkerNominalResultsTupleSchemeFactory implements SchemeFactory {
    public WorkerNominalResultsTupleScheme getScheme() {
      return new WorkerNominalResultsTupleScheme();
    }
  }

  private static class WorkerNominalResultsTupleScheme extends TupleScheme<WorkerNominalResults> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WorkerNominalResults struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCm()) {
        optionals.set(0);
      }
      if (struct.isSetEval_cm()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetCm()) {
        struct.cm.write(oprot);
      }
      if (struct.isSetEval_cm()) {
        struct.eval_cm.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WorkerNominalResults struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.cm = new ConfusionMatrix();
        struct.cm.read(iprot);
        struct.setCmIsSet(true);
      }
      if (incoming.get(1)) {
        struct.eval_cm = new ConfusionMatrix();
        struct.eval_cm.read(iprot);
        struct.setEval_cmIsSet(true);
      }
    }
  }

}

