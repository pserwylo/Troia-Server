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

public class TLObject implements org.apache.thrift.TBase<TLObject, TLObject._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TLObject");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField GOLD_LABEL_FIELD_DESC = new org.apache.thrift.protocol.TField("goldLabel", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField EVAL_LABEL_FIELD_DESC = new org.apache.thrift.protocol.TField("evalLabel", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TLObjectStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TLObjectTupleSchemeFactory());
  }

  public String id; // required
  public TLabel goldLabel; // required
  public TLabel evalLabel; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    GOLD_LABEL((short)2, "goldLabel"),
    EVAL_LABEL((short)3, "evalLabel");

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
        case 1: // ID
          return ID;
        case 2: // GOLD_LABEL
          return GOLD_LABEL;
        case 3: // EVAL_LABEL
          return EVAL_LABEL;
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
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.GOLD_LABEL, new org.apache.thrift.meta_data.FieldMetaData("goldLabel", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TLabel.class)));
    tmpMap.put(_Fields.EVAL_LABEL, new org.apache.thrift.meta_data.FieldMetaData("evalLabel", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TLabel.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TLObject.class, metaDataMap);
  }

  public TLObject() {
  }

  public TLObject(
    String id,
    TLabel goldLabel,
    TLabel evalLabel)
  {
    this();
    this.id = id;
    this.goldLabel = goldLabel;
    this.evalLabel = evalLabel;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TLObject(TLObject other) {
    if (other.isSetId()) {
      this.id = other.id;
    }
    if (other.isSetGoldLabel()) {
      this.goldLabel = new TLabel(other.goldLabel);
    }
    if (other.isSetEvalLabel()) {
      this.evalLabel = new TLabel(other.evalLabel);
    }
  }

  public TLObject deepCopy() {
    return new TLObject(this);
  }

  @Override
  public void clear() {
    this.id = null;
    this.goldLabel = null;
    this.evalLabel = null;
  }

  public String getId() {
    return this.id;
  }

  public TLObject setId(String id) {
    this.id = id;
    return this;
  }

  public void unsetId() {
    this.id = null;
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return this.id != null;
  }

  public void setIdIsSet(boolean value) {
    if (!value) {
      this.id = null;
    }
  }

  public TLabel getGoldLabel() {
    return this.goldLabel;
  }

  public TLObject setGoldLabel(TLabel goldLabel) {
    this.goldLabel = goldLabel;
    return this;
  }

  public void unsetGoldLabel() {
    this.goldLabel = null;
  }

  /** Returns true if field goldLabel is set (has been assigned a value) and false otherwise */
  public boolean isSetGoldLabel() {
    return this.goldLabel != null;
  }

  public void setGoldLabelIsSet(boolean value) {
    if (!value) {
      this.goldLabel = null;
    }
  }

  public TLabel getEvalLabel() {
    return this.evalLabel;
  }

  public TLObject setEvalLabel(TLabel evalLabel) {
    this.evalLabel = evalLabel;
    return this;
  }

  public void unsetEvalLabel() {
    this.evalLabel = null;
  }

  /** Returns true if field evalLabel is set (has been assigned a value) and false otherwise */
  public boolean isSetEvalLabel() {
    return this.evalLabel != null;
  }

  public void setEvalLabelIsSet(boolean value) {
    if (!value) {
      this.evalLabel = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((String)value);
      }
      break;

    case GOLD_LABEL:
      if (value == null) {
        unsetGoldLabel();
      } else {
        setGoldLabel((TLabel)value);
      }
      break;

    case EVAL_LABEL:
      if (value == null) {
        unsetEvalLabel();
      } else {
        setEvalLabel((TLabel)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case GOLD_LABEL:
      return getGoldLabel();

    case EVAL_LABEL:
      return getEvalLabel();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case GOLD_LABEL:
      return isSetGoldLabel();
    case EVAL_LABEL:
      return isSetEvalLabel();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TLObject)
      return this.equals((TLObject)that);
    return false;
  }

  public boolean equals(TLObject that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (!this.id.equals(that.id))
        return false;
    }

    boolean this_present_goldLabel = true && this.isSetGoldLabel();
    boolean that_present_goldLabel = true && that.isSetGoldLabel();
    if (this_present_goldLabel || that_present_goldLabel) {
      if (!(this_present_goldLabel && that_present_goldLabel))
        return false;
      if (!this.goldLabel.equals(that.goldLabel))
        return false;
    }

    boolean this_present_evalLabel = true && this.isSetEvalLabel();
    boolean that_present_evalLabel = true && that.isSetEvalLabel();
    if (this_present_evalLabel || that_present_evalLabel) {
      if (!(this_present_evalLabel && that_present_evalLabel))
        return false;
      if (!this.evalLabel.equals(that.evalLabel))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TLObject other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TLObject typedOther = (TLObject)other;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, typedOther.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGoldLabel()).compareTo(typedOther.isSetGoldLabel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGoldLabel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.goldLabel, typedOther.goldLabel);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEvalLabel()).compareTo(typedOther.isSetEvalLabel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEvalLabel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.evalLabel, typedOther.evalLabel);
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
    StringBuilder sb = new StringBuilder("TLObject(");
    boolean first = true;

    sb.append("id:");
    if (this.id == null) {
      sb.append("null");
    } else {
      sb.append(this.id);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("goldLabel:");
    if (this.goldLabel == null) {
      sb.append("null");
    } else {
      sb.append(this.goldLabel);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("evalLabel:");
    if (this.evalLabel == null) {
      sb.append("null");
    } else {
      sb.append(this.evalLabel);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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

  private static class TLObjectStandardSchemeFactory implements SchemeFactory {
    public TLObjectStandardScheme getScheme() {
      return new TLObjectStandardScheme();
    }
  }

  private static class TLObjectStandardScheme extends StandardScheme<TLObject> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TLObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.id = iprot.readString();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // GOLD_LABEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.goldLabel = new TLabel();
              struct.goldLabel.read(iprot);
              struct.setGoldLabelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // EVAL_LABEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.evalLabel = new TLabel();
              struct.evalLabel.read(iprot);
              struct.setEvalLabelIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TLObject struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.id != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.goldLabel != null) {
        oprot.writeFieldBegin(GOLD_LABEL_FIELD_DESC);
        struct.goldLabel.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.evalLabel != null) {
        oprot.writeFieldBegin(EVAL_LABEL_FIELD_DESC);
        struct.evalLabel.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TLObjectTupleSchemeFactory implements SchemeFactory {
    public TLObjectTupleScheme getScheme() {
      return new TLObjectTupleScheme();
    }
  }

  private static class TLObjectTupleScheme extends TupleScheme<TLObject> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TLObject struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetGoldLabel()) {
        optionals.set(1);
      }
      if (struct.isSetEvalLabel()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetId()) {
        oprot.writeString(struct.id);
      }
      if (struct.isSetGoldLabel()) {
        struct.goldLabel.write(oprot);
      }
      if (struct.isSetEvalLabel()) {
        struct.evalLabel.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TLObject struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.id = iprot.readString();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.goldLabel = new TLabel();
        struct.goldLabel.read(iprot);
        struct.setGoldLabelIsSet(true);
      }
      if (incoming.get(2)) {
        struct.evalLabel = new TLabel();
        struct.evalLabel.read(iprot);
        struct.setEvalLabelIsSet(true);
      }
    }
  }

}

