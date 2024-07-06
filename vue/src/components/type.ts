import type { CSSProperties } from 'vue';

export interface IVirtualWaterFallProps {
  gap: number;
  column: number;
  pageSize: number;
  enterSize?: number;
  request: (page: number, pageSize: number) => Promise<ICardItem[]>;
}

export interface ICardItem {
  id: number | string;
  width: number;
  height: number;
  [key: string]: any;
}

export interface IColumnQueue {
  list: IRenderItem[];
  height: number;
}

// 渲染视图项
export interface IRenderItem {
  item: ICardItem;
  y: number;
  h: number;
  style: CSSProperties;
}

export interface IItemRect {
  width: number;
  height: number;
}

export interface IBookColumnQueue {
  list: IBookRenderItem[];
  height: number;
}

export interface IBookRenderItem {
  item: ICardItem;
  y: number;
  h: number;
  imageHeight: number;
  style: CSSProperties;
}

export interface IBookItemRect {
  width: number;
  height: number;
  imageHeight: number;
}

/**
 * 旅游景区信息
 */
export interface ITravelScenicItem {
  scenicId: number; // 景区ID
  name: string; // 景区名称
  province: string; // 省
  city: string; // 市
  district: string | null; // 区
  description: string | null; // 景区简介
  imageUrl: string | null; // 景区图片URL
  imageWidth: number | null; // 景区图片宽度
  imageHeight: number | null; // 景区图片高度
  imageMainColor: string | null; // 景区图片主色
  createBy: string | null;
  createTime: string | null; // 创建时间
  updateBy: string | null;
  updateTime: string | null;
  remark: string | null;
}
