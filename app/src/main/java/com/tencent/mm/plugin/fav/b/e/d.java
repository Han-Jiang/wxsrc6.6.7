package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.mm.bt.h;
import com.tencent.mm.plugin.fav.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class d
  extends i<g>
  implements com.tencent.mm.plugin.fav.a.x
{
  private static final String iXS = "xml,edittime,ext,favProto,flag,fromUser,id,itemStatus,localId,localSeq,realChatName,sourceCreateTime,sourceId,sourceType,toUser,type" + ",updateSeq,updateTime,tagProto,sessionId,datatotalsize,rowid";
  private e diF;
  
  public d(e parame)
  {
    super(parame, g.dhO, "FavItemInfo", null);
    this.diF = parame;
  }
  
  private static boolean pM(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = a.iVp;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final g Bs(String paramString)
  {
    Cursor localCursor = this.diF.a("FavItemInfo", null, "sourceId=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      paramString = new g();
      paramString.d(localCursor);
      localCursor.close();
      return paramString;
    }
    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", new Object[] { paramString });
    localCursor.close();
    return null;
  }
  
  public final ArrayList<g> a(List<Long> paramList, List<g> paramList1, Set<Integer> paramSet, w paramw)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramList.size() > 20)) {}
    Object localObject;
    do
    {
      return null;
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("select ").append(iXS).append(" from FavItemInfo where ");
      if ((paramSet != null) && (paramSet.size() > 0))
      {
        ((StringBuffer)localObject).append("( 1=1");
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          Integer localInteger = (Integer)paramSet.next();
          ((StringBuffer)localObject).append(" and type != ").append(localInteger);
        }
        ((StringBuffer)localObject).append(") and ");
      }
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        if (i == 0) {
          ((StringBuffer)localObject).append("( ");
        }
        if (i == j - 1) {
          ((StringBuffer)localObject).append("localId = ").append(paramList.get(i)).append(" )");
        }
        for (;;)
        {
          i += 1;
          break;
          ((StringBuffer)localObject).append("localId = ").append(paramList.get(i)).append(" or ");
        }
      }
      ((StringBuffer)localObject).append(" order by updateTime desc");
      paramList = ((StringBuffer)localObject).toString();
      com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", new Object[] { paramList });
      localObject = this.diF.b(paramList, null, 2);
    } while (localObject == null);
    if (((Cursor)localObject).moveToFirst())
    {
      paramSet = new ArrayList();
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        paramList = new g();
        label313:
        paramList.d((Cursor)localObject);
        if ((paramw == null) || (!paramw.t(paramList))) {
          break label401;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[] { Integer.valueOf(paramList.field_id), Integer.valueOf(paramList.field_type) });
        label366:
        if (((Cursor)localObject).moveToNext()) {
          break label408;
        }
      }
    }
    for (paramList = paramSet;; paramList = null)
    {
      ((Cursor)localObject).close();
      return paramList;
      paramList = (g)paramList1.remove(0);
      break label313;
      label401:
      paramSet.add(paramList);
      break label366;
      label408:
      break;
    }
  }
  
  public final List<g> a(int paramInt, Set<Integer> paramSet, w paramw)
  {
    if ((paramSet != null) && (paramSet.contains(Integer.valueOf(paramInt))))
    {
      com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select " + iXS + " from FavItemInfo where itemStatus > 0";
    if (paramInt != -1) {
      paramSet = (String)localObject + " and type = " + paramInt;
    }
    for (;;)
    {
      paramSet = paramSet + " order by updateTime desc limit 20";
      paramSet = this.diF.b(paramSet, null, 2);
      if (paramSet == null)
      {
        return localArrayList;
        if (paramSet != null)
        {
          Iterator localIterator = paramSet.iterator();
          for (;;)
          {
            paramSet = (Set<Integer>)localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramInt = ((Integer)localIterator.next()).intValue();
            localObject = (String)localObject + " and type != " + paramInt;
          }
        }
      }
      else
      {
        while (paramSet.moveToNext())
        {
          localObject = new g();
          ((g)localObject).d(paramSet);
          if ((paramw != null) && (paramw.t((g)localObject))) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[] { Integer.valueOf(((g)localObject).field_id), Integer.valueOf(((g)localObject).field_type) });
          } else {
            localArrayList.add(localObject);
          }
        }
        paramSet.close();
        return localArrayList;
      }
      paramSet = (Set<Integer>)localObject;
    }
  }
  
  public final boolean a(g paramg, String... paramVarArgs)
  {
    wr localwr;
    if (paramg.field_favProto.rBG != null)
    {
      localwr = paramg.field_favProto.rBG;
      if (localwr.bJt > 0) {
        break label153;
      }
      com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localwr.bJt) });
      localwr.CO(1);
    }
    for (;;)
    {
      b.a(paramg);
      boolean bool = super.b(paramg, false, paramVarArgs);
      if (bool) {
        b(paramg.field_localId, 3, Long.valueOf(paramg.field_localId));
      }
      com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", new Object[] { Boolean.valueOf(bool) });
      return bool;
      label153:
      localwr.CO(localwr.bJt);
    }
  }
  
  public final int aLA()
  {
    int i = 0;
    Cursor localCursor = rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      i = localCursor.getInt(0);
      localCursor.close();
    }
    return i;
  }
  
  public final List<g> aLB()
  {
    Object localObject = "select " + iXS + " from FavItemInfo where itemStatus=3";
    localObject = this.diF.rawQuery((String)localObject, null);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    while (((Cursor)localObject).moveToNext())
    {
      g localg = new g();
      localg.d((Cursor)localObject);
      localLinkedList.add(localg);
    }
    ((Cursor)localObject).close();
    return localLinkedList;
  }
  
  public final List<g> aLC()
  {
    LinkedList localLinkedList = null;
    Object localObject = "select " + iXS + " from FavItemInfo where itemStatus=1";
    localObject = this.diF.b((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localLinkedList = new LinkedList();
      do
      {
        g localg = new g();
        localg.d((Cursor)localObject);
        localLinkedList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localLinkedList;
  }
  
  public final List<g> aLD()
  {
    ArrayList localArrayList = null;
    Object localObject = "select " + iXS + " from FavItemInfo where (itemStatus=9 or itemStatus=12)";
    localObject = this.diF.b((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        g localg = new g();
        localg.d((Cursor)localObject);
        localArrayList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final List<g> aLE()
  {
    ArrayList localArrayList = null;
    Object localObject = "select " + iXS + " from FavItemInfo where itemStatus=17";
    localObject = this.diF.b((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        g localg = new g();
        localg.d((Cursor)localObject);
        localArrayList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final List<g> aLF()
  {
    ArrayList localArrayList = null;
    Object localObject = "select " + iXS + " from FavItemInfo where itemStatus=3 or itemStatus=6 or itemStatus=11 or itemStatus=14 or itemStatus=16 or itemStatus=18";
    localObject = this.diF.b((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        g localg = new g();
        localg.d((Cursor)localObject);
        localArrayList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final List<g> aLG()
  {
    ArrayList localArrayList = null;
    Object localObject = "select " + iXS + " from FavItemInfo where flag =  -1 and itemStatus = 0 ";
    localObject = this.diF.b((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      localArrayList = new ArrayList();
      do
      {
        g localg = new g();
        localg.d((Cursor)localObject);
        localArrayList.add(localg);
      } while (((Cursor)localObject).moveToNext());
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final List<Long> aLH()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = "";
    Object localObject2 = a.iVp;
    int j = localObject2.length;
    int i = 0;
    int k;
    while (i < j)
    {
      k = localObject2[i];
      localObject1 = (String)localObject1 + k + ",";
      i += 1;
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith(",")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localObject1 = "select localId from FavItemInfo where " + " itemStatus in (" + (String)localObject2 + ")";
    String str = (String)localObject1 + " and datatotalsize > 0 ";
    localObject1 = "";
    localObject2 = a.iVo;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject1 = (String)localObject1 + k + ",";
      i += 1;
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith(",")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localObject1 = str + " and type in (" + (String)localObject2 + ")";
    localObject1 = (String)localObject1 + " order by datatotalsize desc";
    localObject1 = this.diF.rawQuery((String)localObject1, null);
    if (localObject1 == null) {
      return localArrayList;
    }
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      return localArrayList;
    }
    while (((Cursor)localObject1).moveToNext()) {
      localArrayList.add(Long.valueOf(((Cursor)localObject1).getLong(0)));
    }
    ((Cursor)localObject1).close();
    long l2 = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", new Object[] { Integer.valueOf(localArrayList.size()), Long.valueOf(l2 - l1) });
    return localArrayList;
  }
  
  public final void aLI()
  {
    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
    Object localObject3 = "select " + iXS + " from FavItemInfo where ";
    Object localObject1 = "";
    Object localObject2 = a.iVp;
    int j = localObject2.length;
    int i = 0;
    int k;
    while (i < j)
    {
      k = localObject2[i];
      localObject1 = (String)localObject1 + k + ",";
      i += 1;
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith(",")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localObject3 = (String)localObject3 + "itemStatus in (" + (String)localObject2 + ")";
    localObject1 = "";
    localObject2 = a.iVo;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      k = localObject2[i];
      localObject1 = (String)localObject1 + k + ",";
      i += 1;
    }
    localObject2 = localObject1;
    if (((String)localObject1).endsWith(",")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
    }
    localObject1 = (String)localObject3 + " and type in (" + (String)localObject2 + ")";
    localObject1 = this.diF.rawQuery((String)localObject1, null);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
      return;
    }
    if (((Cursor)localObject1).getCount() == 0)
    {
      ((Cursor)localObject1).close();
      com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
      return;
    }
    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + ((Cursor)localObject1).getCount());
    long l2;
    if ((this.diF instanceof h)) {
      l2 = ((h)this.diF).dO(Thread.currentThread().getId());
    }
    for (;;)
    {
      if (((Cursor)localObject1).moveToNext())
      {
        localObject2 = new g();
        ((g)localObject2).d((Cursor)localObject1);
        if (pM(((g)localObject2).field_itemStatus))
        {
          if (((g)localObject2).field_favProto != null)
          {
            localObject3 = ((g)localObject2).field_favProto.rBI.iterator();
            for (long l1 = 0L;; l1 = ((vx)((Iterator)localObject3).next()).rzJ + l1)
            {
              l3 = l1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            }
          }
          long l3 = 0L;
          ((g)localObject2).field_datatotalsize = l3;
          a((g)localObject2, new String[] { "localId" });
        }
      }
      else
      {
        if ((this.diF instanceof h)) {
          ((h)this.diF).gp(l2);
        }
        ((Cursor)localObject1).close();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
        return;
        l2 = 0L;
      }
    }
  }
  
  public final List<Long> aLJ()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = "select localId from FavItemInfo" + " order by updateTime desc";
    localObject = this.diF.b((String)localObject, null, 2);
    if (localObject == null) {
      return localArrayList;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      return localArrayList;
    }
    while (((Cursor)localObject).moveToNext()) {
      localArrayList.add(Long.valueOf(((Cursor)localObject).getLong(0)));
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final e aLz()
  {
    return this.diF;
  }
  
  /* Error */
  public final List<g> b(long paramLong, int paramInt, Set<Integer> paramSet, w paramw)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +27 -> 29
    //   5: aload 4
    //   7: iload_3
    //   8: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11: invokeinterface 203 2 0
    //   16: ifeq +13 -> 29
    //   19: ldc 85
    //   21: ldc_w 429
    //   24: invokestatic 208	com/tencent/mm/sdk/platformtools/x:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aconst_null
    //   28: areturn
    //   29: new 164	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 165	java/util/ArrayList:<init>	()V
    //   36: astore 7
    //   38: new 15	java/lang/StringBuilder
    //   41: dup
    //   42: ldc 107
    //   44: invokespecial 21	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: getstatic 33	com/tencent/mm/plugin/fav/b/e/d:iXS	Ljava/lang/String;
    //   50: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 431
    //   56: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload_1
    //   60: invokevirtual 265	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 6
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpeq +97 -> 167
    //   73: new 15	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   80: aload 6
    //   82: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc -43
    //   87: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload_3
    //   91: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 4
    //   99: new 15	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   106: aload 4
    //   108: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 433
    //   114: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 4
    //   122: new 15	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   129: aload 4
    //   131: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc -103
    //   136: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore 4
    //   144: aload_0
    //   145: getfield 48	com/tencent/mm/plugin/fav/b/e/d:diF	Lcom/tencent/mm/sdk/e/e;
    //   148: aload 4
    //   150: aconst_null
    //   151: iconst_2
    //   152: invokeinterface 162 4 0
    //   157: astore 4
    //   159: aload 4
    //   161: ifnonnull +87 -> 248
    //   164: aload 7
    //   166: areturn
    //   167: aload 4
    //   169: ifnull +145 -> 314
    //   172: aload 4
    //   174: invokeinterface 121 1 0
    //   179: astore 8
    //   181: aload 6
    //   183: astore 4
    //   185: aload 8
    //   187: invokeinterface 126 1 0
    //   192: ifeq -93 -> 99
    //   195: aload 8
    //   197: invokeinterface 130 1 0
    //   202: checkcast 132	java/lang/Integer
    //   205: invokevirtual 221	java/lang/Integer:intValue	()I
    //   208: istore_3
    //   209: new 15	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   216: aload 6
    //   218: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc -122
    //   223: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: iload_3
    //   227: invokevirtual 216	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore 6
    //   235: goto -54 -> 181
    //   238: astore 6
    //   240: ldc 85
    //   242: ldc_w 435
    //   245: invokestatic 372	com/tencent/mm/sdk/platformtools/x:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 4
    //   250: invokeinterface 190 1 0
    //   255: ifeq +49 -> 304
    //   258: new 37	com/tencent/mm/plugin/fav/a/g
    //   261: dup
    //   262: invokespecial 76	com/tencent/mm/plugin/fav/a/g:<init>	()V
    //   265: astore 6
    //   267: aload 6
    //   269: aload 4
    //   271: invokevirtual 80	com/tencent/mm/plugin/fav/a/g:d	(Landroid/database/Cursor;)V
    //   274: aload 5
    //   276: ifnull +15 -> 291
    //   279: aload 5
    //   281: aload 6
    //   283: invokeinterface 174 2 0
    //   288: ifne -40 -> 248
    //   291: aload 7
    //   293: aload 6
    //   295: invokeinterface 222 2 0
    //   300: pop
    //   301: goto -53 -> 248
    //   304: aload 4
    //   306: invokeinterface 83 1 0
    //   311: aload 7
    //   313: areturn
    //   314: aload 6
    //   316: astore 4
    //   318: goto -219 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	d
    //   0	321	1	paramLong	long
    //   0	321	3	paramInt	int
    //   0	321	4	paramSet	Set<Integer>
    //   0	321	5	paramw	w
    //   66	168	6	str	String
    //   238	1	6	localException	Exception
    //   265	50	6	localg	g
    //   36	276	7	localArrayList	ArrayList
    //   179	17	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   267	274	238	java/lang/Exception
  }
  
  public final boolean b(g paramg, String... paramVarArgs)
  {
    wr localwr;
    if (paramg.field_favProto.rBG != null)
    {
      localwr = paramg.field_favProto.rBG;
      if (localwr.bJt > 0) {
        break label90;
      }
      com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localwr.bJt) });
      localwr.CO(1);
    }
    for (;;)
    {
      return super.b(paramg, false, paramVarArgs);
      label90:
      localwr.CO(localwr.bJt);
    }
  }
  
  public final g dy(long paramLong)
  {
    if (this.diF == null)
    {
      com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
      return null;
    }
    Cursor localCursor = this.diF.a("FavItemInfo", null, "localId=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      g localg = new g();
      try
      {
        localg.d(localCursor);
        localCursor.close();
        return localg;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
        localCursor.close();
        return null;
      }
    }
    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", new Object[] { Long.valueOf(paramLong) });
    localCursor.close();
    return null;
  }
  
  public final g dz(long paramLong)
  {
    Object localObject = "Select * from FavItemInfo where id = " + paramLong;
    localObject = this.diF.rawQuery((String)localObject, null);
    if (((Cursor)localObject).getCount() != 0)
    {
      g localg = new g();
      ((Cursor)localObject).moveToFirst();
      try
      {
        localg.d((Cursor)localObject);
        ((Cursor)localObject).close();
        return localg;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", localException, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", new Object[] { Long.valueOf(paramLong) });
        ((Cursor)localObject).close();
        return null;
      }
    }
    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", new Object[] { Long.valueOf(paramLong) });
    ((Cursor)localObject).close();
    return null;
  }
  
  public final int pL(int paramInt)
  {
    Object localObject = "select count(*) from FavItemInfo where id>" + paramInt;
    try
    {
      localObject = this.diF.b((String)localObject, null, 2);
      if (localObject == null) {
        return -1;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        return -1;
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "getFavHomePosition failed with throwable: " + localThrowable.getMessage());
      return -1;
    }
    localThrowable.moveToNext();
    paramInt = localThrowable.getInt(0);
    localThrowable.close();
    return paramInt;
  }
  
  public final boolean r(long paramLong, int paramInt)
  {
    String str = "select count(updateTime) from FavItemInfo where updateTime < " + paramLong;
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = this.diF.b((String)localObject, null, 2);
    if (localObject == null) {
      return true;
    }
    ((Cursor)localObject).moveToFirst();
    if (((Cursor)localObject).getInt(0) == 0)
    {
      ((Cursor)localObject).close();
      return true;
    }
    ((Cursor)localObject).close();
    return false;
  }
  
  public final long s(long paramLong, int paramInt)
  {
    long l;
    if (this.diF == null)
    {
      com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
      l = 0L;
      return l;
    }
    if (paramLong == 0L)
    {
      localObject = "select updateTime from FavItemInfo where itemStatus > 0";
      if (paramInt != -1) {
        localObject = "select updateTime from FavItemInfo where itemStatus > 0" + " and type = " + paramInt;
      }
      localObject = (String)localObject + " order by updateTime desc limit 20";
      localObject = this.diF.rawQuery((String)localObject, null);
      if (localObject == null) {
        return 0L;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        return 0L;
      }
      ((Cursor)localObject).moveToLast();
      paramLong = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return paramLong;
    }
    String str = "select updateTime from FavItemInfo where updateTime < " + paramLong;
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = (String)localObject + " and itemStatus > 0";
    localObject = (String)localObject + " order by updateTime desc limit 20";
    localObject = this.diF.rawQuery((String)localObject, null);
    if ((localObject != null) && (((Cursor)localObject).getCount() > 0))
    {
      ((Cursor)localObject).moveToLast();
      paramLong = ((Cursor)localObject).getLong(0);
    }
    for (;;)
    {
      l = paramLong;
      if (localObject == null) {
        break;
      }
      ((Cursor)localObject).close();
      return paramLong;
    }
  }
  
  public final LinkedList<Integer> t(long paramLong, int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    String str = "select id from FavItemInfo where updateTime >= " + paramLong;
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = (String)localObject + " and updateSeq > localSeq";
    localObject = (String)localObject + " order by updateTime desc";
    localObject = this.diF.b((String)localObject, null, 2);
    if (localObject == null) {
      return localLinkedList;
    }
    while (((Cursor)localObject).moveToNext()) {
      localLinkedList.add(Integer.valueOf(((Cursor)localObject).getInt(0)));
    }
    ((Cursor)localObject).close();
    return localLinkedList;
  }
  
  public final void t(int paramInt, long paramLong)
  {
    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    String str = "update FavItemInfo set itemStatus = " + paramInt + " where localId = " + paramLong;
    this.diF.fV("FavItemInfo", str);
    Xp(String.valueOf(paramLong));
  }
  
  public final long u(long paramLong, int paramInt)
  {
    if (this.diF == null)
    {
      com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
      return 0L;
    }
    if (paramLong == 0L)
    {
      localObject = "select updateTime from (select * from FavItemInfo";
      if (paramInt != -1) {
        localObject = "select updateTime from (select * from FavItemInfo" + " where type = " + paramInt;
      }
      localObject = (String)localObject + " order by updateTime desc limit 20";
      localObject = (String)localObject + ") where updateSeq > localSeq";
      localObject = this.diF.rawQuery((String)localObject, null);
      if (localObject == null) {
        return 0L;
      }
      if (((Cursor)localObject).getCount() == 0)
      {
        ((Cursor)localObject).close();
        return 0L;
      }
      ((Cursor)localObject).moveToLast();
      paramLong = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      return paramLong;
    }
    String str = "select updateTime from (select * from FavItemInfo where updateTime < " + paramLong;
    Object localObject = str;
    if (paramInt != -1) {
      localObject = str + " and type = " + paramInt;
    }
    localObject = (String)localObject + " order by updateTime desc limit 20";
    localObject = (String)localObject + ") where updateSeq > localSeq";
    localObject = this.diF.rawQuery((String)localObject, null);
    if (localObject == null) {
      return 0L;
    }
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      return 0L;
    }
    ((Cursor)localObject).moveToLast();
    paramLong = ((Cursor)localObject).getLong(0);
    ((Cursor)localObject).close();
    return paramLong;
  }
  
  public final boolean y(g paramg)
  {
    boolean bool;
    wr localwr;
    if (paramg.field_localId > 0L)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramg.field_favProto.rBG != null)
      {
        localwr = paramg.field_favProto.rBG;
        if (localwr.bJt > 0) {
          break label150;
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[] { Integer.valueOf(paramg.field_id), Long.valueOf(paramg.field_localId), Integer.valueOf(paramg.field_type), Integer.valueOf(localwr.bJt) });
        localwr.CO(1);
      }
    }
    for (;;)
    {
      b.a(paramg);
      bool = a(paramg, false);
      if (bool) {
        b(paramg.field_localId, 2, Long.valueOf(paramg.field_localId));
      }
      return bool;
      bool = false;
      break;
      label150:
      localwr.CO(localwr.bJt);
    }
  }
  
  public final void z(g paramg)
  {
    String str = "delete from FavItemInfo where localId = " + paramg.field_localId;
    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: " + str);
    this.diF.fV("FavItemInfo", str);
    b(paramg.field_localId, 5, Long.valueOf(paramg.field_localId));
  }
}


/* Location:              /Users/Han/Desktop/wxall/微信反编译/反编译 6.6.7/dex2jar-2.0/classes7-dex2jar.jar!/com/tencent/mm/plugin/fav/b/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */