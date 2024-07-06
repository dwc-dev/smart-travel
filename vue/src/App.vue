<template>
  <div class="app">
    <div class="container" ref="fContainerRef">
      <FsBookVirtualWaterfall
        :request="getData"
        :gap="15"
        :page-size="20"
        :column="column"
        :enter-size="column * 2"
      >
        <template #item="{ item, imageHeight }">
          <FsBookCard
            :detail="{
              imageHeight,
              title: item.title,
              address: item.address,
              imageUrl: item.imageUrl,
              bgColor: item.bgColor,
            }"
            @click="handleCardClick($event, item)"
          />
        </template>
      </FsBookVirtualWaterfall>
    </div>

    <FsBookMask :show="maskShow" @close="maskShow = false">
      <FsBookDetail :show="maskShow" :elRect="imageElRect" :data="detailData" />
    </FsBookMask>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue';

import FsBookCard from '@/components/FsBookCard.vue';
import FsBookVirtualWaterfall from '@/components/FsBookVirtualWaterfall.vue';
import FsBookMask from '@/components/FsBookMask.vue';
import FsBookDetail from '@/components/FsBookDetail.vue';

import { fetchTravelScenicList } from '@/api/api';

import type { ICardItem } from '@/components/type';

const fContainerRef = ref<HTMLDivElement | null>(null);
const column = ref(6);
const fContainerObserver = new ResizeObserver((entries) => {
  changeColumn(entries[0].target.clientWidth);
});

const changeColumn = (width: number) => {
  if (width >= 960) {
    column.value = 5;
  } else if (width >= 690) {
    column.value = 4;
  } else if (width >= 500) {
    column.value = 3;
  } else {
    column.value = 2;
  }
};

onMounted(() => {
  if (fContainerRef.value) {
    fContainerObserver.observe(fContainerRef.value);
  }
});

onUnmounted(() => {
  if (fContainerRef.value) {
    fContainerObserver.unobserve(fContainerRef.value);
  }
});

const getData = async (
  page: number,
  pageSize: number,
): Promise<ICardItem[]> => {
  try {
    const list = await fetchTravelScenicList();

    const data: ICardItem[] = [];
    for (const item of list.slice(
      (page - 1) * pageSize,
      (page - 1) * pageSize + pageSize,
    )) {
      let address: string | null = null;
      if (item.province === item.city) {
        if (item.district) {
          address = `${item.province}-${item.district}`;
        } else {
          address = `${item.province}`;
        }
      } else if (item.district) {
        address = `${item.province}-${item.city}-${item.district}`;
      } else {
        address = `${item.province}-${item.city}`;
      }

      data.push({
        ...item,
        id: item.scenicId,
        title: item.name,
        address,
        bgColor: item.imageMainColor ?? 'pink',
        width: item.imageWidth ?? 100,
        height: item.imageHeight ?? 120,
      });
    }

    return data;
  } catch (error) {
    alert(error);
    throw error;
  }
};

const maskShow = ref(false);
const imageElRect = ref(new DOMRect());
const detailData = ref<ICardItem | null>(null);

const handleCardClick = async (event: MouseEvent, item: ICardItem) => {
  const image = (event.target as Element)
    .closest('.fs-book-card-container')!
    .getElementsByClassName('fs-book-card-image')[0];
  imageElRect.value = image.getBoundingClientRect() ?? new DOMRect();
  detailData.value = item;
  maskShow.value = true;
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}
</style>

<style scoped lang="scss">
.app {
  width: 100%;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;

  .container {
    width: 1400px;
    height: 600px;
    border: 1px solid red;
  }
}
</style>
